package com.reciperegistry.Models;

import com.reciperegistry.Service.CustomLogService;

public class RecipeStatistics {
    private String categoryName;
    private Integer categoryValue;

    public RecipeStatistics() {
        CustomLogService.entityLog("RecipeStatistics", true);
    }

    public RecipeStatistics(String categoryName, Integer categoryValue) {
        CustomLogService.entityLog("RecipeStatistics");

        this.categoryName = categoryName;
        this.categoryValue = categoryValue;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(Integer categoryValue) {
        this.categoryValue = categoryValue;
    }
}
