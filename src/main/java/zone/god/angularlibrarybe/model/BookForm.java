package zone.god.angularlibrarybe.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class BookForm {
    private long id;
    private String name, author;
    private double price;
    private String description;
    private String image;
    private long category;

    public BookForm() {
    }
}
