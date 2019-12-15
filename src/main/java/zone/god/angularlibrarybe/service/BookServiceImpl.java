package zone.god.angularlibrarybe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zone.god.angularlibrarybe.model.Book;
import zone.god.angularlibrarybe.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        if(bookRepository.findById(id).isPresent()){
            return bookRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Book save(Book book) {
         bookRepository.save(book);
         return book;
    }

    @Override
    public Book delete(long id) {
        Book book = findById(id);
        bookRepository.deleteById(id);
        return book;
    }
}
