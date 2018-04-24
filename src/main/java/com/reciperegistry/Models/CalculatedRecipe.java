package com.reciperegistry.Models;

import com.reciperegistry.Entity.Ingredient;
import com.reciperegistry.Service.CustomLogService;

import java.util.List;

public class CalculatedRecipe {
    private List<Ingredient> ingredients;
    private String description;

    public CalculatedRecipe() {
        CustomLogService.entityLog("CalculatedRecipe", true);
    }

    public CalculatedRecipe(List<Ingredient> ingredients, String description) {
        CustomLogService.entityLog("CalculatedRecipe");

        this.ingredients = ingredients;
        this.description = description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
