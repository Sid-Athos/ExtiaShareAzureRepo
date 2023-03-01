package extia.hackathon.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Entity(name="ACCOUNT")
public class AccountEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name="EMAIL", unique = true, nullable = false, length=50)
    private String mailAddress;

    @Column(name = "UUID_NFC", unique = true, nullable = false, length=32)
    private String nfcUuid;

    @Column(name="PASSWORD", nullable = false)
    private Long password = 4L;

    @Column(name="CREATION_DATE", nullable = false)
    private Timestamp creationDate = Timestamp.from(Instant.now());

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getNfcUuid() {
        return nfcUuid;
    }

    public void setNfcUuid(String nfcUuid) {
        this.nfcUuid = nfcUuid;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEntity that = (AccountEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!mailAddress.equals(that.mailAddress)) return false;
        if (!nfcUuid.equals(that.nfcUuid)) return false;
        if (!password.equals(that.password)) return false;
        if (!creationDate.equals(that.creationDate)) return false;
        return company.equals(that.company);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + mailAddress.hashCode();
        result = 31 * result + nfcUuid.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + company.hashCode();
        return result;
    }
}
