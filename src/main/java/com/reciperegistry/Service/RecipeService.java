package com.reciperegistry.Service;

import com.reciperegistry.Entity.Recipe;
import com.reciperegistry.Repository.CategoryRepository;
import com.reciperegistry.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Recipe> getAllRecipes() {
        CustomLogService.serviceLog("getAllRecipes()", "RecipeService");

        List<Recipe> recipeList = new ArrayList<>();
        recipeRepository.findAll().forEach(recipe -> {
            recipe.setTypeName(this.getCategoryName(recipe));
            recipeList.add(recipe);
        });
        return this.getSortedRecipeList(recipeList);
    }

    private List<Recipe> getSortedRecipeList(List<Recipe> recipes) {
        CustomLogService.serviceLog("getSortedRecipeList()", "RecipeService");

        return recipes.stream()
                .sorted(Comparator.comparing(recipe -> recipe.getName().toLowerCase())).collect(Collectors.toList());
    }

    private String getCategoryName(Recipe recipe) {
        CustomLogService.serviceLog("getCategoryName()", "RecipeService");

        return categoryRepository.findById(recipe.getType()).get().getName();
    }

    public Recipe getRecipeById(Integer id) {
        CustomLogService.serviceLog("getRecipeById()", "RecipeService");

        return recipeRepository.findById(id).get();
    }

    public void deleteRecipeById(Integer id) {
        CustomLogService.serviceLog("deleteRecipeById()", "RecipeService");

        recipeRepository.deleteById(id);
    }

    public Recipe updateRecipe(Recipe recipe) {
        CustomLogService.serviceLog("updateRecipe()", "RecipeService");

        return recipeRepository.save(recipe);
    }

    public Recipe insertRecipe(Recipe recipe) {
        CustomLogService.serviceLog("insertRecipe()", "RecipeService");

        return recipeRepository.save(recipe);
    }
}
