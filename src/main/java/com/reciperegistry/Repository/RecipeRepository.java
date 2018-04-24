package com.reciperegistry.Repository;

import com.reciperegistry.Entity.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
    public List<Recipe> findByType(Integer type);
}
