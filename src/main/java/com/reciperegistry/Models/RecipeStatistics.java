package com.reciperegistry.Models;

import com.reciperegistry.Service.CustomLogService;

/**
 * This class is responsible for creating recipe statistics.
 *
 * @author Szatmári Mihály
 */
public class RecipeStatistics {
    private String categoryName;
    private Integer categoryValue;

    /**
     * This is the empty constructor of the class.
     */
    public RecipeStatistics() {
        CustomLogService.modelLog("RecipeStatistics", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param categoryName  the category name of the recipe
     * @param categoryValue the number of the recipes
     */
    public RecipeStatistics(String categoryName, Integer categoryValue) {
        CustomLogService.modelLog("RecipeStatistics");

        this.categoryName = categoryName;
        this.categoryValue = categoryValue;
    }

    /**
     * Returns the category name of the recipe.
     *
     * @return the category name of the recipe
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name of the recipe.
     *
     * @param categoryName the category name of the recipe
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Returns the number of recipes.
     *
     * @return the number of recipes.
     */
    public Integer getCategoryValue() {
        return categoryValue;
    }

    /**
     * Sets the number of recipes.
     *
     * @param categoryValue the number of recipes
     */
    public void setCategoryValue(Integer categoryValue) {
        this.categoryValue = categoryValue;
    }
}
