package com.reciperegistry.Models;

import com.reciperegistry.Service.CustomLogService;

public class RecipeToCalculate {
    public Integer recipeId;
    public Integer numberOfServings;

    public RecipeToCalculate() {
        CustomLogService.entityLog("RecipeToCalculate", true);
    }

    public RecipeToCalculate(Integer recipeId, Integer numberOfServings) {
        CustomLogService.entityLog("RecipeToCalculate");

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
