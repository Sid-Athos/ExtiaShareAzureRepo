package esgi.hackathon.server.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "PRODUCTS")
public class ProductsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length=50)
    private String name;

    @Column(nullable = false, length=32)
    private String description;

    @OneToMany
    @Column(unique = true, nullable = false, length=32)
    private List<CategoriesEntity> categoriesEntitySet;


}
