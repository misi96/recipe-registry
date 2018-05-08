package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

/**
 * This class is responsible for creating an ingredient entity.
 *
 * @author Szatmári Mihály
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {
    /**
     * This is the id of the ingredient.
     */
    @Id
    @GeneratedValue()
    private Integer id;
    /**
     * This is the name of the ingredient.
     */
    private String name;
    /**
     * This is the quantity of the ingredient.
     */
    private Double quantity;
    /**
     * This is the quantity type of the ingredient.
     */
    @Column(name = "quantity_type")
    private Integer quantityType;
    /**
     * This is the quantity type name of the ingredient.
     */
    @Column(name = "quantity_type_name")
    private String quantityTypeName;
    /**
     * This is the energy of the ingredient.
     */
    private Double energy;
    /**
     * This is the related recipe id of the ingredient.
     */
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
     * @param newName             the name of the ingredient
     * @param newQuantity         the quantity of the ingredient
     * @param newQuantityType     the quantity type of the ingredient
     * @param newQuantityTypeName the quantity type name of the ingredient
     * @param newEnergy           the energy of the ingredient
     * @param newRecipeId         the related recipe id of the ingredient
     */
    public Ingredient(final String newName,
                      final Double newQuantity,
                      final Integer newQuantityType,
                      final String newQuantityTypeName,
                      final Double newEnergy,
                      final Integer newRecipeId) {
        CustomLogService.entityLog("Ingredient");

        this.name = newName;
        this.quantity = newQuantity;
        this.quantityType = newQuantityType;
        this.quantityTypeName = newQuantityTypeName;
        this.energy = newEnergy;
        this.recipeId = newRecipeId;
    }

    /**
     * Returns the id of the ingredient.
     * * @return the id of the ingredient
     */
    public final Integer
    getId() {
        return id;
    }

    /**
     * Returns the name of the ingredient.
     *
     * @return the name of the ingredient
     */
    public final String
    getName() {
        return name;
    }

    /**
     * Sets the name of the ingredient.
     *
     * @param newName the name of the ingredient
     */
    public final void
    setName(final String newName) {
        this.name = newName;
    }

    /**
     * Returns the quantity of the ingredient.
     *
     * @return the quantity of the ingredient
     */
    public final Double
    getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the ingredient.
     *
     * @param newQuantity the quantity of the ingredient
     */
    public final void
    setQuantity(final Double newQuantity) {
        this.quantity = newQuantity;
    }

    /**
     * Returns the quantity type of the ingredient.
     *
     * @return the quantity type of the ingredient
     */
    public final Integer
    getQuantityType() {
        return quantityType;
    }

    /**
     * Sets the quantity type of the ingredient.
     *
     * @param newQuantityType the quantity type of the ingredient
     */
    public final void
    setQuantityType(final Integer newQuantityType) {
        this.quantityType = newQuantityType;
    }

    /**
     * Returns the quantity type name of the ingredient.
     *
     * @return the quantity type name of the ingredient
     */
    public final String
    getQuantityTypeName() {
        return quantityTypeName;
    }

    /**
     * Sets the quantity type name of the ingredient.
     *
     * @param newQuantityTypeName the quantity type name of the ingredient
     */
    public final void
    setQuantityTypeName(final String newQuantityTypeName) {
        this.quantityTypeName = newQuantityTypeName;
    }

    /**
     * Returns the energy of the ingredient.
     *
     * @return the energy of the ingredient
     */
    public final Double
    getEnergy() {
        return energy;
    }

    /**
     * Sets the energy of the ingredient.
     *
     * @param newEnergy the energy of the ingredient
     */
    public final void
    setEnergy(final Double newEnergy) {
        this.energy = newEnergy;
    }

    /**
     * Returns the related recipe id of the ingredient.
     *
     * @return the related recipe id of the ingredient
     */
    public final Integer
    getRecipeId() {
        return recipeId;
    }

    /**
     * Sets related the recipe id of the ingredient.
     *
     * @param newRecipeId the related recipe id of the ingredient
     */
    public final void
    setRecipeId(final Integer newRecipeId) {
        this.recipeId = newRecipeId;
    }
}
