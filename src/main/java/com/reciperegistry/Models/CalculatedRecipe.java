package com.reciperegistry.Models;

import com.reciperegistry.Entity.Ingredient;

import java.util.List;

public class CalculatedRecipe {
    private List<Ingredient> ingredients;
    private String description;

    public CalculatedRecipe() {
    }

    public CalculatedRecipe(List<Ingredient> ingredients, String description) {
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
