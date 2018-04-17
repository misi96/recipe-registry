package com.reciperegistry.Models;

public class RecipeToCalculate {
    public Integer recipeId;
    public Integer numberOfServings;

    public RecipeToCalculate() {
    }

    public RecipeToCalculate(Integer recipeId, Integer numberOfServings) {
        this.recipeId = recipeId;
        this.numberOfServings = numberOfServings;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
    }
}
