package com.reciperegistry.Controller;

import com.reciperegistry.Models.CalculatedRecipe;
import com.reciperegistry.Models.RecipeToCalculate;
import com.reciperegistry.Service.CustomLogService;
import com.reciperegistry.Service.ServingCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is responsible for handling serving calculator related Rest points.
 *
 * @author Szatmári Mihály
 */
@RestController
@RequestMapping("/serving-calculator")
public class ServingCalculatorController {
    @Autowired
    private ServingCalculatorService servingCalculatorService;

    /**
     * Calls the {@link ServingCalculatorService#getCalculatedRecipe(RecipeToCalculate)} method from {@link ServingCalculatorService}.
     *
     * @param recipeToCalculate the recipe id and the number of servings
     * @return the calculated ingredients and description
     */
    @PostMapping("recipe")
    public CalculatedRecipe getCalculatedRecipe(@RequestBody RecipeToCalculate recipeToCalculate) {
        CustomLogService.controllerLog("serving-calculator/recipe", "ServingCalculatorController");

        return this.servingCalculatorService.getCalculatedRecipe(recipeToCalculate);
    }
}
