package com.reciperegistry.Models;

import com.reciperegistry.Service.CustomLogService;

/**
 * This class is responsible for creating recipe statistics.
 *
 * @author Szatmári Mihály
 */
public class RecipeStatistics {
    /**
     * This is the category name of the recipe.
     */
    private String categoryName;
    /**
     * This is the number of recipes.
     */
    private Integer categoryValue;

    /**
     * This is the empty constructor of the class.
     */
    public RecipeStatistics() {
        CustomLogService
                .modelLog("RecipeStatistics", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param newCategoryName  the category name of the recipe
     * @param newCategoryValue the number of the recipes
     */
    public
    RecipeStatistics(final String newCategoryName,
                     final Integer newCategoryValue) {
        CustomLogService
                .modelLog("RecipeStatistics");

        this.categoryName = newCategoryName;
        this.categoryValue = newCategoryValue;
    }

    /**
     * Returns the category name of the recipe.
     *
     * @return the category name of the recipe
     */
    public final String
    getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name of the recipe.
     *
     * @param newCategoryName the category name of the recipe
     */
    public final void
    setCategoryName(final String newCategoryName) {
        this.categoryName = newCategoryName;
    }

    /**
     * Returns the number of recipes.
     *
     * @return the number of recipes.
     */
    public final Integer
    getCategoryValue() {
        return categoryValue;
    }

    /**
     * Sets the number of recipes.
     *
     * @param newCategoryValue the number of recipes
     */
    public final void
    setCategoryValue(final Integer newCategoryValue) {
        this.categoryValue = newCategoryValue;
    }
}
