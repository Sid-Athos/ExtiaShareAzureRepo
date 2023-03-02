package extia.hackathon.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTION_CARD_ID")
    private Long id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(nullable = false)
    private Long size = 1L;

}