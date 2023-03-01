package extia.hackathon.entities;


import javax.persistence.*;
import java.util.Objects;

@Entity(name="CATEGORY")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true, nullable = false, length=32)
    public String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CategoryEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
