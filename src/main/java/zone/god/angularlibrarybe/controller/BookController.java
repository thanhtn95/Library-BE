package zone.god.angularlibrarybe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zone.god.angularlibrarybe.model.Book;
import zone.god.angularlibrarybe.model.BookForm;
import zone.god.angularlibrarybe.model.Category;
import zone.god.angularlibrarybe.service.BookService;
import zone.god.angularlibrarybe.service.CategoryService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<Iterable<Book>> getBookList() {
        Iterable<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/newBook")
    public ResponseEntity<Book> addBook(@RequestBody BookForm bookForm) {
        Book book = new Book();
        book.setName(bookForm.getName());
        book.setAuthor(bookForm.getAuthor());
        book.setPrice(bookForm.getPrice());
        book.setCategory(categoryService.findById(bookForm.getCategory()));
        book.setDescription(bookForm.getDescription());
        book.setImage(bookForm.getImage());
        bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/deleteBook")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        Book book = bookService.delete(id);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody BookForm bookForm) {
        Book book = new Book();
        book.setId(bookForm.getId());
        book.setName(bookForm.getName());
        book.setAuthor(bookForm.getAuthor());
        book.setPrice(bookForm.getPrice());
        book.setCategory(categoryService.findById(bookForm.getCategory()));
        book.setDescription(bookForm.getDescription());
        book.setImage(bookForm.getImage());
        bookService.save(book);
        return new ResponseEntity<>(book, HttpStatus.ACCEPTED);
    }

}
