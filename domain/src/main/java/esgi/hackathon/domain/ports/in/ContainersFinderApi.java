package esgi.hackathon.domain.ports.in;

import esgi.hackathon.domain.functional.model.Container;

import java.util.List;

public interface ContainersFinderApi {

    List<Container> findAllWithProductsForCompany(Long companyId);
}
