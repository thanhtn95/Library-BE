package zone.god.angularlibrarybe.service;

import org.springframework.stereotype.Service;
import zone.god.angularlibrarybe.model.Book;


public interface BookService {
    Iterable<Book> findAll();
    Book findById(long id);
    Book save(Book book);
    Book delete(long id);
}
