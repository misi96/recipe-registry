package com.reciperegistry.Controller;

import com.reciperegistry.Models.CalculatedRecipe;
import com.reciperegistry.Models.RecipeToCalculate;
import com.reciperegistry.Service.ServingCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/serving-calculator")
public class ServingCalculatorController {
    @Autowired
    private ServingCalculatorService servingCalculatorService;

    @PostMapping("recipe")
    public CalculatedRecipe getCalculatedRecipe(@RequestBody RecipeToCalculate recipeToCalculate) {
        return servingCalculatorService.getCalculatedRecipe(recipeToCalculate);
    }
}
