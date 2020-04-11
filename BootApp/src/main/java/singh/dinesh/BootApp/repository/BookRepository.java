package singh.dinesh.BootApp.repository;

import org.springframework.data.repository.CrudRepository;
import singh.dinesh.BootApp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
