package com.reciperegistry.Entity;

import com.reciperegistry.Service.CustomLogService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class is responsible for creating a category entity.
 *
 * @author Szatmári Mihály
 */
@Entity
@Table(name = "category")
public class Category {
    /**
     * This is the id of the category.
     */
    @Id
    @GeneratedValue()
    private Integer id;
    /**
     * This is the name of the category.
     */
    private String name;
    /**
     * This is the type of the category.
     */
    private String type;

    /**
     * This is the empty constructor of the class.
     */
    public Category() {
        CustomLogService.entityLog("Category", true);
    }

    /**
     * This is the constructor of the class.
     *
     * @param newName the name of the category
     * @param newType the type of the category
     */
    public Category(final String newName, final String newType) {
        CustomLogService.entityLog("Category");

        this.name = newName;
        this.type = newType;
    }

    /**
     * Returns the id of the category.
     *
     * @return the id of the category
     */
    public final Integer
    getId() {
        return id;
    }

    /**
     * Returns the name of the category.
     *
     * @return the name of the category
     */
    public final String
    getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param newName the name of the category
     */
    public final void
    setName(final String newName) {
        this.name = newName;
    }

    /**
     * Returns the type of the category.
     *
     * @return the type of the category
     */
    public final String
    getType() {
        return type;
    }

    /**
     * Sets the type of the category.
     *
     * @param newType the type of the category
     */
    public final void
    setType(final String newType) {
        this.type = newType;
    }
}
