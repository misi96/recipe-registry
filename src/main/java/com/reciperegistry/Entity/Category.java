package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.*;

/**
 * This class is responsible for creating a category entity.
 *
 * @author Szatmári Mihály
 */
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue()
    private Integer id;
    private String name;
    private String type;

    /**
     * This is the empty constructor of the class.
     */
    public Category() {
        CustomLogService.entityLog("Category", true);
    }

    /**
     * This is the constructor of the class.
     */
    public Category(String name, String type) {
        CustomLogService.entityLog("Category");

        this.name = name;
        this.type = type;
    }

    /**
     * Returns the id of the category.
     *
     * @return the id of the category
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the name of the category.
     *
     * @return the name of the category
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name the name of the category
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the type of the category.
     *
     * @return the type of the category
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the category.
     *
     * @param type the type of the category
     */
    public void setType(String type) {
        this.type = type;
    }
}
