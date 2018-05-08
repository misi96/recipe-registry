package com.reciperegistry.Service;

import com.reciperegistry.Entity.Recipe;
import com.reciperegistry.Repository.CategoryRepository;
import com.reciperegistry.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is responsible for recipe related operations.
 *
 * @author Szatmári Mihály
 */
@Service
public class RecipeService {
    /**
     * This repository contains the recipes.
     */
    @Autowired
    private RecipeRepository recipeRepository;

    /**
     * This repository contains the categories.
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Calls the {@link RecipeRepository#findAll()} method
     * from {@link RecipeRepository}, sets the category name
     * and returns a list of all recipes.
     *
     * @return a list of all recipes
     */
    public final List<Recipe>
    getAllRecipes() {
        CustomLogService
                .serviceLog("getAllRecipes()",
                        "RecipeService");

        List<Recipe> recipeList = new ArrayList<>();
        this.recipeRepository.findAll().forEach(recipe -> {
            recipe.setCategoryName(this.getCategoryName(recipe));
            recipeList.add(recipe);
        });

        return this.getSortedRecipeList(recipeList);
    }

    /**
     * Sorts a list of recipes by name and returns the sorted list.
     *
     * @param recipes the list of recipes which should be sorted by name
     * @return a sorted list of recipes by name
     */
    private List<Recipe>
    getSortedRecipeList(final List<Recipe> recipes) {
        CustomLogService
                .serviceLog("getSortedRecipeList()",
                        "RecipeService");

        return recipes.stream()
                .sorted(Comparator
                        .comparing(recipe -> recipe.getName()
                                .toLowerCase())).collect(Collectors.toList());
    }

    /**
     * Returns the category name of the recipe.
     *
     * @param recipe an existing recipe
     * @return the category name of the recipe
     */
    private String
    getCategoryName(final Recipe recipe) {
        CustomLogService
                .serviceLog("getCategoryName()",
                "RecipeService");

        return this.categoryRepository
                .findById(recipe.getCategory()).get().getName();
    }

    /**
     * Calls the {@link RecipeRepository#findById(Object)} ()}
     * method from {@link RecipeRepository} and returns a recipe by id.
     *
     * @param id the id of the recipe
     * @return a recipe by id
     */
    public final Recipe
    getRecipeById(final Integer id) {
        CustomLogService
                .serviceLog("getRecipeById()",
                        "RecipeService");

        return this.recipeRepository.findById(id).get();
    }

    /**
     * Calls the {@link RecipeRepository#deleteById(Object)}
     * method from {@link RecipeRepository} and deletes a recipe
     * from the database by id.
     *
     * @param id the id of the recipe
     */
    public final void
    deleteRecipeById(final Integer id) {
        CustomLogService
                .serviceLog("deleteRecipeById()",
                "RecipeService");

        this.recipeRepository.deleteById(id);
    }

    /**
     * Calls the {@link RecipeRepository#save(Object)} method
     * from {@link RecipeRepository}, updates a recipe in the database
     * and returns the updated recipe.
     *
     * @param recipe the recipe which should be updated
     * @return the updated recipe
     */
    public final Recipe
    updateRecipe(final Recipe recipe) {
        CustomLogService
                .serviceLog("updateRecipe()",
                        "RecipeService");

        return this.recipeRepository.save(recipe);
    }

    /**
     * Calls the {@link RecipeRepository#save(Object)} method from
     * {@link RecipeRepository}, inserts a new recipe into the database
     * and returns the new recipe.
     *
     * @param recipe the new recipe
     * @return the new recipe
     */
    public final Recipe
    insertRecipe(final Recipe recipe) {
        CustomLogService
                .serviceLog("insertRecipe()",
                        "RecipeService");

        return this.recipeRepository.save(recipe);
    }
}
