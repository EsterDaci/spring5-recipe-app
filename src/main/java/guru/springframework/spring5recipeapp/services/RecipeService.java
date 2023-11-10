package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.Domain.Recipe;
import guru.springframework.spring5recipeapp.commands.RecipeCommand;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
