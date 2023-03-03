package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.ContainerDto;
import esgi.hackathon.client.rest.dto.CreateStoredProductRequest;
import esgi.hackathon.client.rest.dto.DeleteStoredProductRequest;
import esgi.hackathon.client.rest.mapper.ContainerDtoMapper;
import esgi.hackathon.client.rest.mapper.StoredProductDtoMapper;
import esgi.hackathon.domain.ports.in.ContainersFinderApi;
import esgi.hackathon.domain.ports.in.StockCreatorApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/stockedProducts")
public class StockedProductsManagementResource {

    private final ContainersFinderApi containersFinderApi;
    private final StockCreatorApi stockCreatorApi;
    public StockedProductsManagementResource(ContainersFinderApi containersFinderApi, StockCreatorApi stockCreatorApi) {
        this.containersFinderApi = containersFinderApi;
        this.stockCreatorApi = stockCreatorApi;
    }

    @GetMapping(path = "/find/groupedByLocation/forCompany/{companyId}")
    public List<ContainerDto> findContainersWithProductsForCompany(@PathVariable("companyId") Long companyId){
        return containersFinderApi.findAllWithProductsForCompany(companyId)
                .stream()
                .map(ContainerDtoMapper::toDto)
                .toList();
    }

    @PostMapping(path="/add")
    public void addProductInContainer(@RequestBody CreateStoredProductRequest storedProductRequest){
        stockCreatorApi.addProductInStock(StoredProductDtoMapper.toDomain(storedProductRequest));
    }

    @PostMapping(path="/remove")
    public void removeProductFromContainer(@RequestBody DeleteStoredProductRequest storedProductRequest){
        stockCreatorApi.removeFromStock(StoredProductDtoMapper.toDomainFromDelete(storedProductRequest));
    }
}
