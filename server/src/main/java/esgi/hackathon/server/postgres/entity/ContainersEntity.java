package esgi.hackathon.server.postgres.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name="CONTAINERS")
@Getter
@Setter
@Builder

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContainersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTAINER_ID")
    private Long id;

    @Column(nullable = false)
    private int size;

    @OneToMany(cascade = CascadeType.ALL)
    private List<StoredProductsEntity> productsInContainer;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private CompaniesEntity company;

}