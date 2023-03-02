package extia.hackathon.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "ACCOUNTS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ID_NFC", unique = true, nullable = false, length=50)
    private String idNFC;

    @Column(name="EMAIL", unique = true, nullable = false, length=50)
    private String mailAddress;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "COMPANY_ID")
    private CompaniesEntity company;

}
