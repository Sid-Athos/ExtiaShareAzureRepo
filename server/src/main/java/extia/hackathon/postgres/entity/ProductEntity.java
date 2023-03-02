package extia.hackathon.postgres.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity(name = "PRODUCTS")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @OneToMany
    @Column(unique = true, nullable = false, length=32)
    private List<CategoriesEntity> categoriesEntitySet;

    @Column(nullable = false, length=32)
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, mappedBy = "productId")
    private List<StockEntity> productStocked;

}
