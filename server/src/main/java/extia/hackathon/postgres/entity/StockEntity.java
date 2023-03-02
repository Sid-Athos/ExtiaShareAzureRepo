package extia.hackathon.postgres.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name="STOCKS")
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COLLECTION_CARD_ID")
    private Long id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity productId;

    @ManyToOne
    @MapsId("companyId")
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity companyId;

    @Column(nullable = false)
    private Date expirationDate;

    @Column(nullable = false)
    private Long size = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }

    public CompanyEntity getCompanyId() {
        return companyId;
    }

    public void setCompanyId(CompanyEntity companyId) {
        this.companyId = companyId;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }
}