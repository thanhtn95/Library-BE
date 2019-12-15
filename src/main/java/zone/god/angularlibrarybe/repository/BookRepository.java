package zone.god.angularlibrarybe.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zone.god.angularlibrarybe.model.Book;

public interface BookRepository extends PagingAndSortingRepository<Book,Long> {
}
