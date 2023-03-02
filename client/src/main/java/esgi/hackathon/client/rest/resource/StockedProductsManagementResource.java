package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.ContainerDto;
import esgi.hackathon.client.rest.mapper.ContainerDtoMapper;
import esgi.hackathon.domain.ports.in.ContainersFinderApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/stockedProducts")
public class StockedProductsManagementResource {

    private final ContainersFinderApi containersFinderApi;

    public StockedProductsManagementResource(ContainersFinderApi containersFinderApi) {
        this.containersFinderApi = containersFinderApi;
    }

    @GetMapping(path = "/find/groupedByLocation/forCompany/{companyId}")
    public List<ContainerDto> findContainersWithProductsForCompany(@PathVariable("companyId") Long companyId){
        return containersFinderApi.findAllWithProductsForCompany(companyId)
                .stream()
                .map(ContainerDtoMapper::toDto)
                .toList();
    }
}
