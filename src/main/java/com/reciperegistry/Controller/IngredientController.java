package com.reciperegistry.Controller;

import com.reciperegistry.Entity.Ingredient;
import com.reciperegistry.Service.CustomLogService;
import com.reciperegistry.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This class is responsible for handling ingredient related Rest points.
 *
 * @author Szatmári Mihály
 */
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    /**
     * Calls the {@link IngredientService#getAllIngredients()} method from {@link IngredientService}.
     *
     * @return a list of all ingredients
     */
    @GetMapping("list")
    public List<Ingredient> getAllIngredients() {
        CustomLogService.controllerLog("ingredient/list", "IngredientController");

        return this.ingredientService.getAllIngredients();
    }

    /**
     * Calls the {@link IngredientService#getIngredientsByRecipeId(Integer)} method from {@link IngredientService}
     *
     * @param id the id of the recipe
     * @return a list of ingredient by recipe id
     */
    @GetMapping("list/{id}")
    public List<Ingredient> getIngredientsByRecipeId(@PathVariable("id") Integer id) {
        CustomLogService.controllerLog("ingredient/list/" + id, "IngredientController");

        return this.ingredientService.getIngredientsByRecipeId(id);
    }

    /**
     * Calls the {@link IngredientService#insertIngredients(List)} method from {@link IngredientService}
     *
     * @param ingredients the list of new ingredients
     */
    @PostMapping("list/add")
    public void insertIngredients(@RequestBody List<Ingredient> ingredients) {
        CustomLogService.controllerLog("ingredient/list/add", "IngredientController");

        this.ingredientService.insertIngredients(ingredients);
    }

    /**
     * Calls the {@link IngredientService#getIngredientById(Integer)} method from {@link IngredientService}
     *
     * @param id the id of the ingredient
     * @return an ingredient by id
     */
    @GetMapping("get/{id}")
    public Ingredient getIngredientById(@PathVariable("id") Integer id) {
        CustomLogService.controllerLog("ingredient/get/" + id, "IngredientController");

        return this.ingredientService.getIngredientById(id);
    }

    /**
     * Calls the {@link IngredientService#deleteIngredientById(Integer)} method from {@link IngredientService}.
     *
     * @param id the id of the ingredient
     */
    @DeleteMapping("delete/{id}")
    public void deleteIngredientById(@PathVariable("id") Integer id) {
        CustomLogService.controllerLog("ingredient/delete/" + id, "IngredientController");

        this.ingredientService.deleteIngredientById(id);
    }

    /**
     * Calls the {@link IngredientService#updateIngredient(Ingredient)} method from {@link IngredientService}.
     *
     * @param ingredient the existing ingredient
     */
    @PutMapping("update")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
        CustomLogService.controllerLog("ingredient/update", "IngredientController");

        this.ingredientService.updateIngredient(ingredient);
    }

    /**
     * Calls the {@link IngredientService#insertIngredient(Ingredient)} method from {@link IngredientService}.
     *
     * @param ingredient the new ingredient
     */
    @PostMapping("add")
    public void insertIngredient(@RequestBody Ingredient ingredient) {
        CustomLogService.controllerLog("ingredient/add", "IngredientController");

        this.ingredientService.insertIngredient(ingredient);
    }
}
