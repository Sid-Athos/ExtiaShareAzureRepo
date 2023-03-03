package esgi.hackathon.server.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name="CONTAINERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ContainersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTAINER_ID")
    private Long id;

    @Column(nullable = false)
    private Integer size;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "container")
    private List<StoredProductsEntity> productsInContainer;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    private CompaniesEntity company;

}