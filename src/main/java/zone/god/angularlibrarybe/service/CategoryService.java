package zone.god.angularlibrarybe.service;

import zone.god.angularlibrarybe.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(long id);

    Category save(Category category);

    Category delete(long id);
}
