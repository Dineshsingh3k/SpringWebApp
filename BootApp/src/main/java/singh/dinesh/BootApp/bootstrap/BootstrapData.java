package singh.dinesh.BootApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import singh.dinesh.BootApp.domain.Author;
import singh.dinesh.BootApp.domain.Book;
import singh.dinesh.BootApp.domain.Publisher;
import singh.dinesh.BootApp.repository.AuthorRepository;
import singh.dinesh.BootApp.repository.BookRepository;
import singh.dinesh.BootApp.repository.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher tata = new Publisher("tataMcgrawHill", "RoseIcon", "Pune", "Maharashtra", "12312312");
        publisherRepository.save(tata);

        Author dinesh = new Author("Dinesh", "Singh");
        Book book1 =  new Book("MyBook", "111111111111111");
        dinesh.getBooks().add(book1);
        book1.getAuthors().add(dinesh);
        book1.setPublisher(tata);
        tata.getBooks().add(book1);

        authorRepository.save(dinesh);
        bookRepository.save(book1);
        publisherRepository.save(tata);

        Author shreya = new Author("Shreya", "Singh");
        Book book2 =  new Book("MyCookeryBook", "2222222222222");
        shreya.getBooks().add(book2);
        book2.getAuthors().add(shreya);
        book2.setPublisher(tata);
        tata.getBooks().add(book2);

        authorRepository.save(shreya);
        bookRepository.save(book2);
        publisherRepository.save(tata);


        System.out.println("Total Books" + bookRepository.count());
        System.out.println("PUblisher " + publisherRepository.count());
        System.out.println("Author" + authorRepository.count());
        System.out.println("Books published by tata : " + tata.getBooks().size());

    }
}
