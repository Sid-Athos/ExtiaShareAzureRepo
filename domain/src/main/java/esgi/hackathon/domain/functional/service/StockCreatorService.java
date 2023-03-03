package esgi.hackathon.domain.functional.service;

import esgi.hackathon.domain.functional.model.Account;
import esgi.hackathon.domain.functional.model.StoredProduct;
import esgi.hackathon.domain.ports.in.StockCreatorApi;
import esgi.hackathon.domain.ports.out.AccountPersistenceSpi;
import esgi.hackathon.domain.ports.out.StockPersistenceSpi;

public class StockCreatorService implements StockCreatorApi {

    private final int POINTS_MODIFICATOR = 1;

    private final StockPersistenceSpi stockPersistenceSpi;

    private final AccountPersistenceSpi accountPersistenceSpi;

    public StockCreatorService(StockPersistenceSpi stockPersistenceSpi, AccountPersistenceSpi accountPersistenceSpi) {
        this.stockPersistenceSpi = stockPersistenceSpi;
        this.accountPersistenceSpi = accountPersistenceSpi;
    }

    @Override
    public Long addProductInStock(StoredProduct storedProduct) {
        var userToUpdate = accountPersistenceSpi.findById(storedProduct.getAccount().getId()).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        var updatedUser = Account.builder()
                .id(userToUpdate.getId())
                .score(computeAddingProductAsScore(userToUpdate.getScore()))
                .company(userToUpdate.getCompany())
                .idNFC(userToUpdate.getIdNFC())
                .logo(userToUpdate.getLogo())
                .mailAddress(userToUpdate.getMailAddress())
                .password(userToUpdate.getPassword())
                .build();
        accountPersistenceSpi.save(updatedUser);
        return stockPersistenceSpi.addProductInStock(storedProduct);
    }

    @Override
    public void removeFromStock(StoredProduct storedProduct) {
        var userToUpdate = accountPersistenceSpi.findById(storedProduct.getAccount().getId()).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        var updatedUser = Account.builder()
                .id(userToUpdate.getId())
                .score(computeRemovingProductAsScore(userToUpdate.getScore()))
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

    private int computeRemovingProductAsScore(int originalValue){
        return originalValue - POINTS_MODIFICATOR;
    }
}
