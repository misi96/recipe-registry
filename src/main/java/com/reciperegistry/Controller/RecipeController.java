package com.reciperegistry.Controller;

import com.reciperegistry.Entity.Recipe;
import com.reciperegistry.Service.CustomLogService;
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
        CustomLogService.controllerLog("recipe/list", "RecipeController");

        return recipeService.getAllRecipes();
    }

    @GetMapping("get/{id}")
    public Recipe getRecipeById(@PathVariable("id") Integer id) {
        CustomLogService.controllerLog("recipe/get/" + id, "RecipeController");

        return recipeService.getRecipeById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteRecipeById(@PathVariable("id") Integer id) {
        CustomLogService.controllerLog("recipe/delete/" + id, "RecipeController");

        recipeService.deleteRecipeById(id);
    }

    @PutMapping("update")
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        CustomLogService.controllerLog("recipe/update", "RecipeController");

        return recipeService.updateRecipe(recipe);
    }

    @PostMapping("add")
    public Recipe insertRecipe(@RequestBody Recipe recipe) {
        CustomLogService.controllerLog("recipe/add", "RecipeController");

        return recipeService.insertRecipe(recipe);
    }
}
