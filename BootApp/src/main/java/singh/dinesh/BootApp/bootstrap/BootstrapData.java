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

        Publisher tata = new Publisher("tataMcgrawHill", "RoseIcon", "Pune", "Maharashtra", "12312312");
        publisherRepository.save(tata);

        System.out.println("Total Books" + bookRepository.count());
        System.out.println("PUblisher " + publisherRepository.count());
        System.out.println("Author" + authorRepository.count());



        /*System.out.println("Dinesh : " + dinesh);
        System.out.println("Book1 : " + book1);
        System.out.println("Shreya : " + shreya);
        System.out.println("Book2 : " + book2);
        System.out.println("Publisher : " + tata);*/
    }
}
