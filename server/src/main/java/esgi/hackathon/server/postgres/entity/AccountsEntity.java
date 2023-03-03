package esgi.hackathon.server.postgres.entity;

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
    @Column(name = "ACCOUNT_ID", nullable = false)
    private Long id;

    @Column(name = "ID_NFC", unique = true, nullable = false, length=50)
    private String idNFC;

    @Column(name="EMAIL", unique = true, nullable = false, length=50)
    private String mailAddress;

    @Column(name="PASSWORD", nullable = false)
    private String password;

    @Column(name="LOGO")
    private String logo;

    @Column(name="score")
    private int score;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "COMPANY_ID")
    private CompaniesEntity company;

}
