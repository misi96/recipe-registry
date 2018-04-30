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
    private List<Ingredient> ingredients;
    private String description;

    /**
     * This is the empty constructor of the class.
     */
    public CalculatedRecipe() {
        CustomLogService.modelLog("CalculatedRecipe", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param ingredients the ingredient of the recipe
     * @param description the description of the recipe
     */
    public CalculatedRecipe(List<Ingredient> ingredients, String description) {
        CustomLogService.modelLog("CalculatedRecipe");

        this.ingredients = ingredients;
        this.description = description;
    }

    /**
     * Returns a list of ingredients of the recipe.
     *
     * @return a list of ingredients of the recipe
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets the list of ingredients of the recipe.
     *
     * @param ingredients the list of ingredients of the recipe
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Returns the description of the recipe.
     *
     * @return the description of the recipe
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the recipe.
     *
     * @param description the description of the recipe
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
