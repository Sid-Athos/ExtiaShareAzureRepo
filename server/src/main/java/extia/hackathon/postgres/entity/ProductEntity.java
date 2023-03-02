package extia.hackathon.postgres.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "PRODUCTS")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @OneToMany
    @Column(unique = true, nullable = false, length=32)
    private Set<CategoryEntity> categoryEntitySet;

    @Column(nullable = false, length=32)
    private String description;


}
