package zone.god.angularlibrarybe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zone.god.angularlibrarybe.model.Category;
import zone.god.angularlibrarybe.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Category>> getCategoryList() {
        Iterable<Category> categories = categoryService.findAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/newCategory")
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<Category>(category, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/deleteCategory")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") long id) {
        Category category = categoryService.delete(id);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PutMapping("/updateCategory")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        categoryService.save(category);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }
}
