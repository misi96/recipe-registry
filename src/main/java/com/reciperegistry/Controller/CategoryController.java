package com.reciperegistry.Controller;

import com.reciperegistry.Entity.Category;
import com.reciperegistry.Service.CategoryService;
import com.reciperegistry.Service.CustomLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * This class is responsible for handling category related Rest points.
 *
 * @author Szatmári Mihály
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * Calls the {@link CategoryService#getRecipeCategories()} method from {@link CategoryService}.
     *
     * @return a list of all recipe categories
     */
    @GetMapping("recipe/list")
    public Collection<Category> getRecipeCategories() {
        CustomLogService.controllerLog("category/recipe/list", "CategoryController");

        return this.categoryService.getRecipeCategories();
    }

    /**
     * Calls the {@link CategoryService#getIngredientQuantityTypes()} method from {@link CategoryService}.
     *
     * @return a list of all ingredient quantity types
     */
    @GetMapping("ingredient/list")
    public Collection<Category> getIngredientQuantityTypes() {
        CustomLogService.controllerLog("category/ingredient/list", "CategoryController");

        return this.categoryService.getIngredientQuantityTypes();
    }
}
