package extia.hackathon.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private List<CategoriesEntity> categoriesEntitySet;


}
