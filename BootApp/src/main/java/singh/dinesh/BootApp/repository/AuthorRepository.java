package singh.dinesh.BootApp.repository;

import org.springframework.data.repository.CrudRepository;
import singh.dinesh.BootApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
