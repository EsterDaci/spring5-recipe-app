package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.Domain.Category;
import io.micrometer.observation.Observation;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByDescription(String description);
}
