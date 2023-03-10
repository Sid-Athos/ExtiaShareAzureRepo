package esgi.hackathon.domain.functional.service;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.in.StockCreatorApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import esgi.hackathon.domain.ports.out.ContainersPersistenceSpi;
import esgi.hackathon.domain.ports.out.ProductPersistenceSpi;
import esgi.hackathon.domain.ports.out.StockPersistenceSpi;

import java.util.Objects;

public class StockCreatorService implements StockCreatorApi {

    private final int POINTS_MODIFICATOR = 1;

    private final StockPersistenceSpi stockPersistenceSpi;

    private final AccountPersistenceSpi accountPersistenceSpi;
    private final ContainersPersistenceSpi containersPersistenceSpi;

    private final ProductPersistenceSpi productPersistenceSpi;

    public StockCreatorService(StockPersistenceSpi stockPersistenceSpi, AccountPersistenceSpi accountPersistenceSpi, ContainersPersistenceSpi containersPersistenceSpi, ProductPersistenceSpi productPersistenceSpi) {
        this.stockPersistenceSpi = stockPersistenceSpi;
        this.accountPersistenceSpi = accountPersistenceSpi;
        this.containersPersistenceSpi = containersPersistenceSpi;
        this.productPersistenceSpi = productPersistenceSpi;
    }

    @Override
    public void addProductInStock(StoredProduct storedProduct) {
        var userToUpdate = accountPersistenceSpi.findById(storedProduct.getAccount().getId()).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        var container = containersPersistenceSpi.findWithEnoughSpace(storedProduct.getSize(), userToUpdate.getCompany().getId());
        if(container == null){
            throw new RuntimeException("No available containers");
        }
        var productToAdd = productPersistenceSpi.findByName(storedProduct.getProduct().getName());
        if(productToAdd.isEmpty()){
            productToAdd = productPersistenceSpi.save(storedProduct.getProduct()).toJavaOptional();
        }
        if(storedProduct.getSize() >= container.getSize()){
            throw new RuntimeException("Illegal operation, product takes too much place");
        }
        container.withSize(computeNewContainerSize(container.getSize(), storedProduct.getSize()));
        var updatedUser = Account.builder()
                .id(userToUpdate.getId())
                .score(computeAddingProductAsScore(userToUpdate.getScore()))
                .company(userToUpdate.getCompany())
                .idNFC(userToUpdate.getIdNFC())
                .logo(userToUpdate.getLogo())
                .mailAddress(userToUpdate.getMailAddress())
                .password(userToUpdate.getPassword())
                .build();
        var toSave = StoredProduct.builder()
                .product(productToAdd.orElseThrow(() -> new RuntimeException(("Invalud product"))))
                        .account(updatedUser)
                        .expirationDate(storedProduct.getExpirationDate())
                        .container(container)
                        .size(computeNewContainerSize(container.getSize(), storedProduct.getSize())).build();
        stockPersistenceSpi.addProductInStock(toSave);
        containersPersistenceSpi.save(container);
        accountPersistenceSpi.save(updatedUser);
    }

    @Override
    public void removeFromStock(StoredProduct storedProduct, Long userId) {
        var userToUpdate = accountPersistenceSpi.findById(userId).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        //var container = containersPersistenceSpi.fin(storedProduct.getSize(), userToUpdate.getCompany().getId());

        int userPoints = userToUpdate.getScore();
        if(!Objects.equals(storedProduct.getAccount().getId(), userId)){
            userPoints = computeRemovingProductAsScore(userPoints);
        }
        var updatedUser = Account.builder()
                .id(userToUpdate.getId())
                .score(userPoints)
                .company(userToUpdate.getCompany())
                .idNFC(userToUpdate.getIdNFC())
                .logo(userToUpdate.getLogo())
                .mailAddress(userToUpdate.getMailAddress())
                .password(userToUpdate.getPassword())
                .build();

        accountPersistenceSpi.save(updatedUser);
        stockPersistenceSpi.removeProductInStock(storedProduct);
    }

    private int computeAddingProductAsScore(int originalValue){
        return originalValue + POINTS_MODIFICATOR;
    }

    private int computeNewContainerSize(int containerSize, int sizeToReduce){
        return containerSize - sizeToReduce;
    }

    private int computeRemovingProductAsScore(int originalValue){
        return originalValue - POINTS_MODIFICATOR;
    }
}
