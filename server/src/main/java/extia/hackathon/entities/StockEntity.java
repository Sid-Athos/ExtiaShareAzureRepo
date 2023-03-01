package extia.hackathon.entities;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTION_CARD_ID")
    Long id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    Long productId;

    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(name = "COMPANY_ID")
    Long companyId;

    @Column(nullable = false)
    Date expirationDate;

    @Column(nullable = false)
    Long size = 1L;

}