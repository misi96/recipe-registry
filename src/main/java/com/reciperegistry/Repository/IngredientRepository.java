package com.reciperegistry.Repository;

import com.reciperegistry.Entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
    public List<Ingredient> findByRecipeId(Integer recipeId);
}
