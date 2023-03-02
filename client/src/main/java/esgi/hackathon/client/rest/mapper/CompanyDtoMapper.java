package esgi.hackathon.client.rest.mapper;


import esgi.hackathon.client.rest.dto.CompanyCreationRequest;
import esgi.hackathon.client.rest.dto.CompanyDto;
import esgi.hackathon.domain.functional.model.Company;

public interface CompanyDtoMapper {

    static CompanyDto toDto(Company company) {
        return new CompanyDto(
                company.getId(),
                company.getName()
        );
    }

    static Company companyCreationToDomain(CompanyCreationRequest request) {
        return Company.builder()
                .name(request.name())
                .build();
    }

}
