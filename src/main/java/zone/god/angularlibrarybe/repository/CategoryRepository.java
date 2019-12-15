package zone.god.angularlibrarybe.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import zone.god.angularlibrarybe.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
