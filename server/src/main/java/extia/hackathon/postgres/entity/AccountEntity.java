package extia.hackathon.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="ACCOUNT")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "ID_NFC", unique = true, nullable = false, length=32)
    private String idNFC;

    @Column(name="EMAIL", unique = true, nullable = false, length=50)
    private String mailAddress;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

}
