package com.reciperegistry.Controller;

import com.reciperegistry.Entity.Recipe;
import com.reciperegistry.Service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("list")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("get/{id}")
    public Recipe getRecipeById(@PathVariable("id") Integer id) {
        return recipeService.getRecipeById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRecipeById(@PathVariable("id") Integer id) {
        recipeService.deleteRecipeById(id);
    }

    @PutMapping("update")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipe);
    }

    @PostMapping("add")
    public Recipe insertRecipe(@RequestBody Recipe recipe) {
        return recipeService.insertRecipe(recipe);
    }
}
