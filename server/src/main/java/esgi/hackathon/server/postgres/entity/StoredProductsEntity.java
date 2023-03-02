package esgi.hackathon.server.postgres.entity;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name="STOCKS")
@Getter
@Setter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StoredProductsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTION_CARD_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductsEntity product;

    @ManyToOne
    @JoinColumn(name = "CONTAINER_ID")
    private ContainerEntity container;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(nullable = false)
    private int size;


}