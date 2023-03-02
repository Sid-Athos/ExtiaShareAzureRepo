package extia.hackathon.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name ="COMPANIES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompaniesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPANY_NAME", unique = true, nullable = false, length = 32)
    private String name;

    @Column(nullable = false, length = 60, name="STOCK_LOCATION")
    private String stockLocation;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE, mappedBy = "companyId")
    private List<StocksEntity> productsInCompany;

}
