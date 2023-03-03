package esgi.hackathon.client.rest.resource;

import esgi.hackathon.client.rest.dto.AccountDepositProductRequest;
import esgi.hackathon.client.rest.dto.AccountDto;
import esgi.hackathon.client.rest.dto.AccountFindRequest;
import esgi.hackathon.client.rest.dto.AccountTakeProductRequest;
import esgi.hackathon.client.rest.mapper.AccountDtoMapper;
import esgi.hackathon.client.rest.mapper.ProductDtoMapper;
import esgi.hackathon.domain.functional.model.Product;
import esgi.hackathon.domain.ports.in.AccountDepositProductApi;
import esgi.hackathon.domain.ports.in.AccountFinderApi;
import esgi.hackathon.domain.ports.in.AccountStoredProductTakerApi;
import esgi.hackathon.domain.ports.in.ProductFinderApi;
import io.vavr.control.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/product")
public class ProductResource {

    private final ProductFinderApi productFinderApi;

    @GetMapping
    public List<Product> getAllProduct() {
        return productFinderApi.findAll();
    }



}
