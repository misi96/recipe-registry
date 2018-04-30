package com.reciperegistry.Repository;

import com.reciperegistry.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is the repository of the ingredients.
 *
 * @author Szatmári Mihály
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    /**
     * Returns a list of ingredients by recipe id.
     *
     * @param recipeId the id of the recipe
     * @return a list of ingredients by recipe id
     */
    public List<Ingredient> findByRecipeId(Integer recipeId);
}
