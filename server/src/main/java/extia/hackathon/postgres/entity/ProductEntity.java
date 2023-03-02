package extia.hackathon.postgres.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity(name = "PRODUCTS")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=50)
    private String name;

    @Column(nullable = false, length=32)
    private String description;

    @OneToMany
    @Column(unique = true, nullable = false, length=32)
    private Set<CategoryEntity> categoryEntitySet;


}
