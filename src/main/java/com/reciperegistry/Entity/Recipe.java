package com.reciperegistry.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer type;
    @Column(name = "type_name")
    private String typeName;
    private Integer difficulty;
    @Column(name = "cooking_time")
    private Integer cookingTime;
    private Integer energy;
    @Column(name = "portion_size")
    private Integer numberOfServings;
    @Column(length = 4096)
    private String description;

    public Recipe() {
    }

    public Recipe(String name, Integer type, String typeName, Integer difficulty, Integer cookingTime, Integer energy, Integer numberOfServings, String description) {
        this.name = name;
        this.type = type;
        this.typeName = typeName;
        this.difficulty = difficulty;
        this.cookingTime = cookingTime;
        this.energy = energy;
        this.numberOfServings = numberOfServings;
        this.description = description;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Integer cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Integer getEnergy() {
        return energy;
    }

    public void setEnergy(Integer energy) {
        this.energy = energy;
    }

    public Integer getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(Integer numberOfServings) {
        this.numberOfServings = numberOfServings;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
