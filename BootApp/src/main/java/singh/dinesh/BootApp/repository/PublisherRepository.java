package singh.dinesh.BootApp.repository;

import org.springframework.data.repository.CrudRepository;
import singh.dinesh.BootApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
