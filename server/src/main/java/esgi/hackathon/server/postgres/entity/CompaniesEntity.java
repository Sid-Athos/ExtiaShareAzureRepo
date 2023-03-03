package esgi.hackathon.server.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name ="COMPANIES")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CompaniesEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID")
    private Long id;

    @Column(name = "NAME", unique = true, nullable = false, length = 32)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ContainersEntity> containersInCompany;

}
