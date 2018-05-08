package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
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
     * @param newName             the name of the recipe
     * @param newCategory         the category of the recipe
     * @param newCategoryName     the category name of the recipe
     * @param newDifficulty       the difficulty of the recipe
     * @param newCookingTime      the cooking time of the recipe
     * @param newEnergy           the energy of the recipe
     * @param newNumberOfServings the number of servings of the recipe
     * @param newDescription      the description of the recipe
     */
    public Recipe(final String newName,
                  final Integer newCategory,
                  final String newCategoryName,
                  final Integer newDifficulty,
                  final Integer newCookingTime,
                  final Integer newEnergy,
                  final Integer newNumberOfServings,
                  final String newDescription) {
        CustomLogService.entityLog("Recipe");

        this.name = newName;
        this.category = newCategory;
        this.categoryName = newCategoryName;
        this.difficulty = newDifficulty;
        this.cookingTime = newCookingTime;
        this.energy = newEnergy;
        this.numberOfServings = newNumberOfServings;
        this.description = newDescription;
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
}
