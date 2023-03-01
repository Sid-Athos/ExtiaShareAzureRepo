package extia.hackathon.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "COMPANY")
public class CompanyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPANY_NAME", unique = true, nullable = false, length = 32)
    private String name;

    @Column(name = "CARD_COLLECTION_NAME", nullable = false, length = 250)
    private String cardCollectionName;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "collectionId")
    private List<StockEntity> cardsInCollection;

}
