package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.*;

/**
 * This class is responsible for creating a recipe entity.
 *
 * @author Szatmári Mihály
 */
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    private Integer category;
    @Column(name = "category_name")
    private String categoryName;
    private Integer difficulty;
    @Column(name = "cooking_time")
    private Integer cookingTime;
    private Integer energy;
    @Column(name = "portion_size")
    private Integer numberOfServings;
    @Column(length = 2048)
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
     * @param name             the name of the recipe
     * @param category         the category of the recipe
     * @param categoryName     the category name of the recipe
     * @param difficulty       the difficulty of the recipe
     * @param cookingTime      the cooking time of the recipe
     * @param energy           the energy of the recipe
     * @param numberOfServings the number of servings of the recipe
     * @param description      the description of the recipe
     */
    public Recipe(String name, Integer category, String categoryName, Integer difficulty, Integer cookingTime, Integer energy, Integer numberOfServings, String description) {
        CustomLogService.entityLog("Recipe");

        this.name = name;
        this.category = category;
        this.categoryName = categoryName;
        this.difficulty = difficulty;
        this.cookingTime = cookingTime;
        this.energy = energy;
        this.numberOfServings = numberOfServings;
        this.description = description;
    }

    /**
     * Returns the id of the recipe.
     *
     * @return the id of the recipe
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the name of the recipe.
     *
     * @return the name of the recipe
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the recipe.
     *
     * @param name the name of the recipe
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the category of the recipe.
     *
     * @return the category of the recipe
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * Sets the category of the recipe.
     *
     * @param category the category of the recipe
     */
    public void setCategory(Integer category) {
        this.category = category;
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
     * Returns the difficulty of the recipe.
     *
     * @return the difficulty of the recipe
     */
    public Integer getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty of the recipe.
     *
     * @param difficulty the difficulty of the recipe
     */
    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Returns the cooking time of the recipe.
     *
     * @return the cooking time of the recipe
     */
    public Integer getCookingTime() {
        return cookingTime;
    }

    /**
     * Sets the cooking time of the recipe.
     *
     * @param cookingTime the cooking time of the recipe
     */
    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    /**
     * Returns the energy of the recipe.
     *
     * @return the energy of the recipe
     */
    public Integer getEnergy() {
        return energy;
    }

    /**
     * Sets the energy of the recipe.
     *
     * @param energy the energy of the recipe
     */
    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    /**
     * Returns the number of servings of the recipe.
     *
     * @return the number of servings of the recipe
     */
    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    /**
     * Sets the number of servings of the recipe.
     *
     * @param numberOfServings the number of servings of the recipe
     */
    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
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
