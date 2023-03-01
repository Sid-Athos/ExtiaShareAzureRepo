package extia.hackathon.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "CARDS")
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @Column(unique = true, nullable = false, length=32)
    private Set<CategoryEntity> categoryEntitySet;

    @Column(nullable = false, length=32)
    private String description;

    @Column(nullable = false, length=32)
    private Date expirationDate;


    @ManyToMany( mappedBy = "cardId")
    private List<StockEntity> collectionCardList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CategoryEntity> getCategoryEntitySet() {
        return categoryEntitySet;
    }

    public void setCategoryEntitySet(Set<CategoryEntity> categoryEntitySet) {
        this.categoryEntitySet = categoryEntitySet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


}
