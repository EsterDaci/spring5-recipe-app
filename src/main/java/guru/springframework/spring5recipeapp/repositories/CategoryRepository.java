package guru.springframework.spring5recipeapp.repositories;

import guru.springframework.spring5recipeapp.Domain.Category;
import io.micrometer.observation.Observation;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Long> {
}
