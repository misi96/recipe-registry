package com.reciperegistry.Controller;

import com.reciperegistry.Entity.Ingredient;
import com.reciperegistry.Service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @GetMapping("list")
    public List<Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }

    @GetMapping("list/{id}")
    public List<Ingredient> getIngredientsByRecipeId(@PathVariable("id") Integer id) {
        return ingredientService.getIngredientsByRecipeId(id);
    }

    @PostMapping("list/add")
    public void insertIngredients(@RequestBody List<Ingredient> ingredients) {
        ingredientService.insertIngredients(ingredients);
    }

    @GetMapping("get/{id}")
    public Ingredient getIngredientById(@PathVariable("id") Integer id) {
        return ingredientService.getIngredientById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteIngredientById(@PathVariable("id") Integer id) {
        ingredientService.deleteIngredientById(id);
    }

    @PutMapping("update")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.updateIngredient(ingredient);
    }

    @PostMapping("add")
    public void insertIngredient(@RequestBody Ingredient ingredient) {
        ingredientService.insertIngredient(ingredient);
    }
}
