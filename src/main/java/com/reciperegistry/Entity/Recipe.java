package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;


/**
 * This class is responsible for creating a recipe entity.
 *
 * @author Szatmári Mihály
 */
@Entity
@Table(name = "recipe")
public class Recipe {
    /**
     * This is the maximum length of the description field.
     */
    private static final Integer MAX_DESCRIPTION_LENGTH = 100;

    /**
     * This is the id of the recipe.
     */
    @Id
    @GeneratedValue()
    private Integer id;
    /**
     * This is the name of the recipe.
     */
    private String name;
    /**
     * This is the category of the recipe.
     */
    private Integer category;
    /**
     * This is the category name of the recipe.
     */
    @Column(name = "category_name")
    private String categoryName;
    /**
     * This is the difficulty of the recipe.
     */
    private Integer difficulty;
    /**
     * This is the cooking time of the recipe.
     */
    @Column(name = "cooking_time")
    private Integer cookingTime;
    /**
     * This is the energy of the recipe.
     */
    private Integer energy;
    /**
     * This is the number of servings of the recipe.
     */
    @Column(name = "portion_size")
    private Integer numberOfServings;
    /**
     * This is the description of the recipe.
     */
    @Column(length = 1024)
    private String description;

    /**
     * This is the empty constructor of the class.
     */
    public Recipe() {
        CustomLogService.entityLog("Recipe", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param builder asdadssdasd
     */
    public Recipe(final Builder builder) {
        CustomLogService.entityLog("Recipe");

        this.name = builder.name;
        this.category = builder.category;
        this.categoryName = builder.categoryName;
        this.difficulty = builder.difficulty;
        this.cookingTime = builder.cookingTime;
        this.energy = builder.energy;
        this.numberOfServings = builder.numberOfServings;
        this.description = builder.description;
    }

    /**
     * Returns the id of the recipe.
     *
     * @return the id of the recipe
     */
    public final Integer
    getId() {
        return id;
    }

    /**
     * Returns the name of the recipe.
     *
     * @return the name of the recipe
     */
    public final String
    getName() {
        return name;
    }

    /**
     * Sets the name of the recipe.
     *
     * @param newName the name of the recipe
     */
    public final void
    setName(final String newName) {
        this.name = newName;
    }

    /**
     * Returns the category of the recipe.
     *
     * @return the category of the recipe
     */
    public final Integer
    getCategory() {
        return category;
    }

    /**
     * Sets the category of the recipe.
     *
     * @param newCategory the category of the recipe
     */
    public final void
    setCategory(final Integer newCategory) {
        this.category = newCategory;
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
     * Returns the difficulty of the recipe.
     *
     * @return the difficulty of the recipe
     */
    public final Integer
    getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty of the recipe.
     *
     * @param newDifficulty the difficulty of the recipe
     */
    public final void
    setDifficulty(final Integer newDifficulty) {
        this.difficulty = newDifficulty;
    }

    /**
     * Returns the cooking time of the recipe.
     *
     * @return the cooking time of the recipe
     */
    public final Integer
    getCookingTime() {
        return cookingTime;
    }

    /**
     * Sets the cooking time of the recipe.
     *
     * @param newCookingTime the cooking time of the recipe
     */
    public final void
    setCookingTime(final Integer newCookingTime) {
        this.cookingTime = newCookingTime;
    }

    /**
     * Returns the energy of the recipe.
     *
     * @return the energy of the recipe
     */
    public final Integer
    getEnergy() {
        return energy;
    }

    /**
     * Sets the energy of the recipe.
     *
     * @param newEnergy the energy of the recipe
     */
    public final void
    setEnergy(final Integer newEnergy) {
        this.energy = newEnergy;
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

    /**
     * Returns the description of the recipe.
     *
     * @return the description of the recipe
     */
    public final String
    getDescription() {
        return description;
    }

    /**
     * Sets the description of the recipe.
     *
     * @param newDescription the description of the recipe
     */
    public final void
    setDescription(final String newDescription) {
        this.description = newDescription;
    }

    /**
     * This is the builder class of the recipes.
     */
    public static class Builder {
        /**
         * This is the name of the recipe.
         */
        private String name;
        /**
         * This is the category of the recipe.
         */
        private Integer category;
        /**
         * This is the category name of the recipe.
         */
        private String categoryName;
        /**
         * This is the difficulty of the recipe.
         */
        private Integer difficulty;
        /**
         * This is the cooking time of the recipe.
         */
        private Integer cookingTime;
        /**
         * This is the energy of the recipe.
         */
        private Integer energy;
        /**
         * This is the number of serving of the recipe.
         */
        private Integer numberOfServings;
        /**
         * This is the description of the recipe.
         */
        private String description;

        /**
         * This is the main builder method which returns a new recipe.
         *
         * @return the new recipe
         */
        public final Recipe build() {
            return new Recipe(this);
        }

        /**
         * Sets the category of the recipe and returns the recipe.
         *
         * @param newCategory the category of the recipe
         * @return the recipe
         */
        public final Builder
        withCategory(final Integer newCategory) {
            this.category = newCategory;
            return this;
        }

        /**
         * Sets the category name of the recipe and returns the recipe.
         *
         * @param newCategoryName the category name of the recipe
         * @return the recipe
         */
        public final Builder
        withCategoryName(final String newCategoryName) {
            this.categoryName = newCategoryName;
            return this;
        }

        /**
         * Sets the difficulty of the recipe and returns the recipe.
         *
         * @param newDifficulty the difficulty of the recipe
         * @return the recipe
         */
        public final Builder
        withDifficulty(final Integer newDifficulty) {
            this.difficulty = newDifficulty;
            return this;
        }

        /**
         * Sets the cooking time of the recipe and returns the recipe.
         *
         * @param newCookingTime the cooking time of the recipe
         * @return the recipe
         */
        public final Builder
        withCookingTime(final Integer newCookingTime) {
            this.cookingTime = newCookingTime;
            return this;
        }

        /**
         * Sets the energy of the recipe and returns the recipe.
         *
         * @param newEnergy the energy of the recipe
         * @return the recipe
         */
        public final Builder
        withEnergy(final Integer newEnergy) {
            this.energy = newEnergy;
            return this;
        }

        /**
         * Sets the numerb of servings of the recipe and returns the recipe.
         *
         * @param newNumberOfServings the number of servings of the recipe
         * @return the recipe
         */
        public final Builder
        withNumberOfServings(final Integer newNumberOfServings) {
            this.numberOfServings = newNumberOfServings;
            return this;
        }

        /**
         * Sets the description of the recipe and returns the recipe.
         *
         * @param newDescription the description of the recipe
         * @return the recipe
         */
        public final Builder
        withDescription(final String newDescription) {
            this.description = newDescription;
            return this;
        }

    }
}
