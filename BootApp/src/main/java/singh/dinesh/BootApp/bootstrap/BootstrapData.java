package singh.dinesh.BootApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import singh.dinesh.BootApp.domain.Author;
import singh.dinesh.BootApp.domain.Book;
import singh.dinesh.BootApp.repository.AuthorRepository;
import singh.dinesh.BootApp.repository.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author dinesh = new Author("Dinesh", "Singh");
        Book book1 =  new Book("MyBook", "111111111111111");
        dinesh.getBooks().add(book1);
        book1.getAuthors().add(dinesh);

        authorRepository.save(dinesh);
        bookRepository.save(book1);

        Author shreya = new Author("Shreya", "Singh");
        Book book2 =  new Book("MyCookeryBook", "2222222222222");
        shreya.getBooks().add(book2);
        book2.getAuthors().add(shreya);

        authorRepository.save(shreya);
        bookRepository.save(book2);

        System.out.println("Total Books" + bookRepository.count());
    }
}
