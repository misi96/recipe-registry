package com.reciperegistry.Repository;

import com.reciperegistry.Entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is the repository of the recipes.
 *
 * @author Szatmári Mihály
 */
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    /**
     * Returns a list of recipes by recipe category.
     *
     * @param category the category of the recipe
     * @return a list of recipes by recipe category
     */
    public List<Recipe> findByCategory(Integer category);
}
