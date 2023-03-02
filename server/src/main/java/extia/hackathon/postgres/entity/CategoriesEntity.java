package extia.hackathon.postgres.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="CATEGORIES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CategoriesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length=32)
    private String name;

}
