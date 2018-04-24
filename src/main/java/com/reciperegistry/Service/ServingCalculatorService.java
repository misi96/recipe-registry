package com.reciperegistry.Service;

import com.reciperegistry.Models.CalculatedRecipe;
import com.reciperegistry.Entity.Ingredient;
import com.reciperegistry.Entity.Recipe;
import com.reciperegistry.Models.RecipeToCalculate;
import com.reciperegistry.Repository.CategoryRepository;
import com.reciperegistry.Repository.IngredientRepository;
import com.reciperegistry.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServingCalculatorService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private List<Ingredient> calculatedIngredientList = new ArrayList<>();

    public CalculatedRecipe getCalculatedRecipe(RecipeToCalculate recipeToCalc) {
        CustomLogService.serviceLog("getCalculatedRecipe()", "ServingCalculatorService");

        RecipeToCalculate recipeToCalculate = new RecipeToCalculate(recipeToCalc.recipeId, recipeToCalc.numberOfServings);
        List<Ingredient> ingredientList = new ArrayList<>();
        String description;
        Recipe recipe;

        ingredientRepository.findByRecipeId(recipeToCalculate.getRecipeId()).forEach(ingredient -> {
            ingredient.setQuantityTypeName(this.getCategoryName(ingredient));
            ingredientList.add(ingredient);
        });

        recipe = recipeRepository.findById(recipeToCalculate.getRecipeId()).get();
        this.calculatedIngredientList = this.getCalculatedIngredients(ingredientList, recipe.getNumberOfServings(), recipeToCalculate.getNumberOfServings());
        description = recipe.getDescription();

        return new CalculatedRecipe(this.calculatedIngredientList, description);
    }

    private String getCategoryName(Ingredient ingredient) {
        CustomLogService.serviceLog("getCategoryName()", "ServingCalculatorService");

        return categoryRepository.findById(ingredient.getQuantityType()).get().getName();
    }

    private List<Ingredient> getCalculatedIngredients(List<Ingredient> ingredients, Integer originalNumberOfServings, Integer numberOfServingsToSet) {
        CustomLogService.serviceLog("getCalculatedIngredients()", "ServingCalculatorService");

        List<Ingredient> calculatedIngredients = new ArrayList<>();
        ingredients.forEach(ingredient -> {
            Double quantity = ingredient.getQuantity() / originalNumberOfServings * numberOfServingsToSet;
            Double energy = ingredient.getEnergy() / originalNumberOfServings * numberOfServingsToSet;

            ingredient.setQuantity(quantity);
            ingredient.setEnergy(energy);

            calculatedIngredients.add(ingredient);
        });
        return calculatedIngredients;
    }
}
