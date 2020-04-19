package guru.springframework.spring5webflux.repositories;

import guru.springframework.spring5webflux.domain.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository<Category,String> {
}
