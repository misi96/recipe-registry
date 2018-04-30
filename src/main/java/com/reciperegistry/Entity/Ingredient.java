package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.*;

/**
 * This class is responsible for creating an ingredient entity.
 *
 * @author Szatmári Mihály
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    private Double quantity;
    @Column(name = "quantity_type")
    private Integer quantityType;
    @Column(name = "quantity_type_name")
    private String quantityTypeName;
    private Double energy;
    @Column(name = "recipe_id")
    private Integer recipeId;

    /**
     * This is the empty constructor of the class.
     */
    public Ingredient() {
        CustomLogService.entityLog("Ingredient", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param name             the name of the ingredient
     * @param quantity         the quantity of the ingredient
     * @param quantityType     the quantity type of the ingredient
     * @param quantityTypeName the quantity type name of the ingredient
     * @param energy           the energy of the ingredient
     * @param recipeId         the related recipe id of the ingredient
     */
    public Ingredient(String name, Double quantity, Integer quantityType, String quantityTypeName, Double energy, Integer recipeId) {
        CustomLogService.entityLog("Ingredient");

        this.name = name;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.quantityTypeName = quantityTypeName;
        this.energy = energy;
        this.recipeId = recipeId;
    }

    /**
     * Returns the id of the ingredient.
     * * @return the id of the ingredient
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the name of the ingredient.
     *
     * @return the name of the ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the ingredient.
     *
     * @param name the name of the ingredient
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the quantity of the ingredient.
     *
     * @return the quantity of the ingredient
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the ingredient.
     *
     * @param quantity the quantity of the ingredient
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the quantity type of the ingredient.
     *
     * @return the quantity type of the ingredient
     */
    public Integer getQuantityType() {
        return quantityType;
    }

    /**
     * Sets the quantity type of the ingredient.
     *
     * @param quantityType the quantity type of the ingredient
     */
    public void setQuantityType(Integer quantityType) {
        this.quantityType = quantityType;
    }

    /**
     * Returns the quantity type name of the ingredient.
     *
     * @return the quantity type name of the ingredient
     */
    public String getQuantityTypeName() {
        return quantityTypeName;
    }

    /**
     * Sets the quantity type name of the ingredient.
     *
     * @param quantityTypeName
     */
    public void setQuantityTypeName(String quantityTypeName) {
        this.quantityTypeName = quantityTypeName;
    }

    /**
     * Returns the energy of the ingredient.
     *
     * @return the energy of the ingredient
     */
    public Double getEnergy() {
        return energy;
    }

    /**
     * Sets the energy of the ingredient.
     *
     * @param energy the energy of the ingredient
     */
    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    /**
     * Returns the related recipe id of the ingredient.
     *
     * @return the related recipe id of the ingredient
     */
    public Integer getRecipeId() {
        return recipeId;
    }

    /**
     * Sets related the recipe id of the ingredient.
     *
     * @param recipeId the related recipe id of the ingredient
     */
    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }
}
