package com.reciperegistry.Service;

import com.reciperegistry.Entity.Ingredient;
import com.reciperegistry.Entity.Recipe;
import com.reciperegistry.Models.CalculatedRecipe;
import com.reciperegistry.Models.RecipeToCalculate;
import com.reciperegistry.Repository.CategoryRepository;
import com.reciperegistry.Repository.IngredientRepository;
import com.reciperegistry.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for handling serving calculator related operations.
 *
 * @author Szatmári Mihály
 */
@Service
public class ServingCalculatorService {
    /**
     * This repository contains the recipes.
     */
    @Autowired
    private RecipeRepository recipeRepository;

    /**
     * This repository contains the ingredients.
     */
    @Autowired
    private IngredientRepository ingredientRepository;

    /**
     * This repository contains the categories.
     */
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * This is the list of the calculated ingredients.
     */
    private List<Ingredient> calculatedIngredientList = new ArrayList<>();

    /**
     * Gets the recipe ingredients with the
     * {@link IngredientRepository#findByRecipeId(Integer)} method,
     * sets the quantity type name with the
     * {@link ServingCalculatorService#getCategoryName(Ingredient)} method
     * and gets the recipe with the {@link RecipeRepository#findById(Object)}
     * then returns the calculated recipe.
     *
     * @param recipeToCalc the id and the number of servings of the recipe
     * @return the ingredients and the description of the recipe
     */
    public final CalculatedRecipe
    getCalculatedRecipe(final RecipeToCalculate recipeToCalc) {
        CustomLogService
                .serviceLog("getCalculatedRecipe()",
                        "ServingCalculatorService");

        RecipeToCalculate recipeToCalculate
                = new RecipeToCalculate(recipeToCalc.getRecipeId(),
                recipeToCalc.getNumberOfServings());
        List<Ingredient> ingredientList = new ArrayList<>();
        String description;
        Recipe recipe;

        this.ingredientRepository
                .findByRecipeId(recipeToCalculate.getRecipeId())
                .forEach(ingredient -> {
                    ingredient
                            .setQuantityTypeName(
                                    this.getCategoryName(ingredient)
                            );
                    ingredientList.add(ingredient);
                });

        recipe = recipeRepository
                .findById(recipeToCalculate.getRecipeId()).get();
        this.calculatedIngredientList
                = this.getCalculatedIngredients(ingredientList,
                recipe.getNumberOfServings(),
                recipeToCalculate.getNumberOfServings());
        description = recipe.getDescription();

        return new CalculatedRecipe(this.calculatedIngredientList,
                description);
    }

    /**
     * Returns the category name of the ingredient.
     *
     * @param ingredient an existing ingredient
     * @return the category name of the ingredient
     */
    private String
    getCategoryName(final Ingredient ingredient) {
        CustomLogService
                .serviceLog("getCategoryName()",
                        "ServingCalculatorService");

        return this.categoryRepository
                .findById(ingredient.getQuantityType()).get().getName();
    }

    /**
     * Calculates the ingredient quantities and returns
     * a list of the calculated ingredients.
     *
     * @param ingredients              the list of the ingredients
     *                                 which should be calculated
     * @param originalNumberOfServings the original number of servings
     * @param numberOfServingsToSet    the chosen number of servings
     * @return a list of the calculated ingredients
     */
    private List<Ingredient>
    getCalculatedIngredients(final List<Ingredient> ingredients,
                             final Integer originalNumberOfServings,
                             final Integer numberOfServingsToSet) {
        CustomLogService
                .serviceLog("getCalculatedIngredients()",
                        "ServingCalculatorService");

        List<Ingredient> calculatedIngredients = new ArrayList<>();
        ingredients.forEach(ingredient -> {
            Double quantity
                    = ingredient.getQuantity()
                    / originalNumberOfServings * numberOfServingsToSet;
            Double energy
                    = ingredient.getEnergy()
                    / originalNumberOfServings * numberOfServingsToSet;

            ingredient.setQuantity(quantity);
            ingredient.setEnergy(energy);

            calculatedIngredients.add(ingredient);
        });

        return calculatedIngredients;
    }
}
