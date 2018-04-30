package com.reciperegistry.Models;

import com.reciperegistry.Service.CustomLogService;

/**
 * This class is responsible for creating recipes which ingredients should be calculated.
 *
 * @author Szatmári Mihály
 */
public class RecipeToCalculate {
    public Integer recipeId;
    public Integer numberOfServings;

    /**
     * This is the empty constructor of the class.
     */
    public RecipeToCalculate() {
        CustomLogService.modelLog("RecipeToCalculate", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param recipeId         the id of the recipe
     * @param numberOfServings the number of servings of the recipe
     */
    public RecipeToCalculate(Integer recipeId, Integer numberOfServings) {
        CustomLogService.modelLog("RecipeToCalculate");

        this.recipeId = recipeId;
        this.numberOfServings = numberOfServings;
    }

    /**
     * Returns the id of the recipe.
     *
     * @return the id of the recipe
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * Sets the id of the recipe.
     *
     * @param recipeId the id of the recipe
     */
    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    /**
     * Returns the number of servings of the recipe.
     *
     * @return the number of servings of the recipe
     */
    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    /**
     * Sets the number of servings of the recipe.
     *
     * @param numberOfServings the number of servings of the recipe
     */
    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
    }
}
