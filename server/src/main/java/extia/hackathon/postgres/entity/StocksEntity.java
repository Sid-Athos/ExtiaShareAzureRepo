package extia.hackathon.postgres.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name="STOCKS")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StocksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTION_CARD_ID")
    private Long id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    private ProductsEntity productId;

    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(name = "COMPANY_ID")
    private CompaniesEntity companyId;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(nullable = false)
    private Long size = 1L;



}