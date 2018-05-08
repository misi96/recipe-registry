package com.reciperegistry.Controller;

import com.reciperegistry.Entity.Recipe;
import com.reciperegistry.Service.CustomLogService;
import com.reciperegistry.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * This class is responsible for recipe related Rest points.
 *
 * @author Szatmári Mihály
 */
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    /**
     * This service contains recipe related operations.
     */
    @Autowired
    private RecipeService recipeService;

    /**
     * Calls the {@link RecipeService#getAllRecipes()} method
     * from {@link RecipeService}.
     *
     * @return a list of all recipes
     */
    @GetMapping("list")
    public final List<Recipe>
    getAllRecipes() {
        CustomLogService
                .controllerLog("recipe/list",
                        "RecipeController");

        return this.recipeService.getAllRecipes();
    }

    /**
     * Calls the {@link RecipeService#getRecipeById(Integer)}
     * method from {@link RecipeService}.
     *
     * @param id the id of the recipe
     * @return a recipe by id
     */
    @GetMapping("get/{id}")
    public final Recipe
    getRecipeById(@PathVariable("id") final Integer id) {
        CustomLogService
                .controllerLog("recipe/get/" + id,
                        "RecipeController");

        return this.recipeService.getRecipeById(id);
    }

    /**
     * Calls the {@link RecipeService#deleteRecipeById(Integer)}
     * method from {@link RecipeService}.
     *
     * @param id the id of the recipe
     */
    @DeleteMapping("delete/{id}")
    public final void
    deleteRecipeById(@PathVariable("id") final Integer id) {
        CustomLogService
                .controllerLog("recipe/delete/" + id,
                "RecipeController");

        this.recipeService.deleteRecipeById(id);
    }

    /**
     * Calls the {@link RecipeService#updateRecipe(Recipe)} method
     * from {@link RecipeService}.
     *
     * @param recipe the existing recipe
     * @return the updated recipe
     */
    @PutMapping("update")
    public final
    Recipe updateRecipe(@RequestBody final Recipe recipe) {
        CustomLogService
                .controllerLog("recipe/update",
                "RecipeController");

        return this.recipeService.updateRecipe(recipe);
    }

    /**
     * Calls the {@link RecipeService#insertRecipe(Recipe)} method
     * from {@link RecipeService}.
     *
     * @param recipe the new recipe
     * @return the inserted recipe
     */
    @PostMapping("add")
    public final
    Recipe insertRecipe(@RequestBody final Recipe recipe) {
        CustomLogService
                .controllerLog("recipe/add",
                "RecipeController");

        return this.recipeService.insertRecipe(recipe);
    }
}
