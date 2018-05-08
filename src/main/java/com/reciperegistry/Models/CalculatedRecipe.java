package com.reciperegistry.Models;

import com.reciperegistry.Entity.Ingredient;
import com.reciperegistry.Service.CustomLogService;

import java.util.List;

/**
 * This class is responsible for creating calculated recipes.
 *
 * @author Szatmári Mihály
 */
public class CalculatedRecipe {
    /**
     * This is the list of the ingredients of the recipe.
     */
    private List<Ingredient> ingredients;
    /**
     * This is the description of the recipe.
     */
    private String description;

    /**
     * This is the empty constructor of the class.
     */
    public CalculatedRecipe() {
        CustomLogService
                .modelLog("CalculatedRecipe", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param newIngredients the list of ingredients of the recipe
     * @param newDescription the description of the recipe
     */
    public
    CalculatedRecipe(final List<Ingredient> newIngredients,
                     final String newDescription) {
        CustomLogService
                .modelLog("CalculatedRecipe");

        this.ingredients = newIngredients;
        this.description = newDescription;
    }

    /**
     * Returns a list of ingredients of the recipe.
     *
     * @return a list of ingredients of the recipe
     */
    public final List<Ingredient>
    getIngredients() {
        return ingredients;
    }

    /**
     * Sets the list of ingredients of the recipe.
     *
     * @param newIngredients the list of ingredients of the recipe
     */
    public final void
    setIngredients(final List<Ingredient> newIngredients) {
        this.ingredients = newIngredients;
    }

    /**
     * Returns the description of the recipe.
     *
     * @return the description of the recipe
     */
    public final String
    getDescription() {
        return description;
    }

    /**
     * Sets the description of the recipe.
     *
     * @param newDescription the description of the recipe
     */
    public final void
    setDescription(final String newDescription) {
        this.description = newDescription;
    }
}
