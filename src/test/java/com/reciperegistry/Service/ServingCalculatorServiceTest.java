package com.reciperegistry.Service;

import com.reciperegistry.Entity.Ingredient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ServingCalculatorServiceTest {
    private ServingCalculatorService servingCalculatorService;

    private List<Ingredient> ingredientList;

    @Before
    public void setUp() {
        this.servingCalculatorService = new ServingCalculatorService();

        Ingredient ingredient;
        ingredient = new Ingredient("TestIngredient", 10.00, 5, "", 50.00, 1);

        this.ingredientList = new ArrayList<>();
        this.ingredientList.add(ingredient);
    }

    @Test
    public void getCalculatedRecipe() {
        Double result = this.servingCalculatorService
                .getCalculatedIngredients(this.ingredientList, 2, 6)
                .get(0).getQuantity();

        assertEquals((Double) 30.00, result);
    }
}