package com.reciperegistry.Models;

import com.reciperegistry.Service.CustomLogService;

/**
 * This class is responsible for creating recipes
 * which ingredients should be calculated.
 *
 * @author Szatmári Mihály
 */
public class RecipeToCalculate {
    /**
     * This is the id of the recipe.
     */
    public Integer recipeId;
    /**
     * This is the number of serving of the recipe.
     */
    public Integer numberOfServings;

    /**
     * This is the empty constructor of the class.
     */
    public RecipeToCalculate() {
        CustomLogService
                .modelLog("RecipeToCalculate", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param newRecipeId         the id of the recipe
     * @param newNumberOfServings the number of servings of the recipe
     */
    public
    RecipeToCalculate(final Integer newRecipeId,
                      final Integer newNumberOfServings) {
        CustomLogService
                .modelLog("RecipeToCalculate");

        this.recipeId = newRecipeId;
        this.numberOfServings = newNumberOfServings;
    }

    /**
     * Returns the id of the recipe.
     *
     * @return the id of the recipe
     */
    public final Integer
    getRecipeId() {
        return recipeId;
    }

    /**
     * Sets the id of the recipe.
     *
     * @param newRecipeId the id of the recipe
     */
    public final void
    setRecipeId(final Integer newRecipeId) {
        this.recipeId = newRecipeId;
    }

    /**
     * Returns the number of servings of the recipe.
     *
     * @return the number of servings of the recipe
     */
    public final Integer
    getNumberOfServings() {
        return numberOfServings;
    }

    /**
     * Sets the number of servings of the recipe.
     *
     * @param newNumberOfServings the number of servings of the recipe
     */
    public final void
    setNumberOfServings(final Integer newNumberOfServings) {
        this.numberOfServings = newNumberOfServings;
    }
}
