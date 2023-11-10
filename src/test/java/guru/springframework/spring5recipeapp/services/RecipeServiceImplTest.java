package guru.springframework.spring5recipeapp.services;

import guru.springframework.spring5recipeapp.Domain.Recipe;
import guru.springframework.spring5recipeapp.converters.RecipeCommandToRecipe;
import guru.springframework.spring5recipeapp.converters.RecipeToRecipeCommand;
import guru.springframework.spring5recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    void getRecipes() {
        Recipe recipe=new Recipe();

        HashSet<Recipe> recipesSet=new HashSet<Recipe>();
        recipesSet.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesSet);

        Set<Recipe> recipeSet=recipeService.getRecipes();
        assertEquals(recipeSet.size(),1);
        verify(recipeRepository,times(1)).findAll();
    }

    @Test
    void testGetRecipes() {
    }

    @Test
    void findById() {
        Recipe recipe=new Recipe();
        recipe.setId(1L);

        Optional<Recipe> recipeOptional=Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe returnedRecipe=recipeService.findById(1L);

       assertNotNull(returnedRecipe,"Null recipe returned");
       verify(recipeRepository,times(1)).findById(anyLong());
       verify(recipeRepository,never()).findAll();

    }
}