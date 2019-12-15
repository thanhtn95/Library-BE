package zone.god.angularlibrarybe.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name, description;

    @OneToMany(targetEntity = Book.class, fetch = FetchType.EAGER)
    private List<Book> books;
    public Category() {
    }
}
