package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue
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

    public Ingredient() {
        CustomLogService.entityLog("Ingredient", true);
    }

    public Ingredient(String name, Double quantity, Integer quantityType, String quantityTypeName, Double energy, Integer recipeId) {
        CustomLogService.entityLog("Ingredient");

        this.name = name;
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.quantityTypeName = quantityTypeName;
        this.energy = energy;
        this.recipeId = recipeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(Integer quantityType) {
        this.quantityType = quantityType;
    }

    public String getQuantityTypeName() {
        return quantityTypeName;
    }

    public void setQuantityTypeName(String quantityTypeName) {
        this.quantityTypeName = quantityTypeName;
    }

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }
}
