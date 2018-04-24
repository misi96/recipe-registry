package com.reciperegistry.Service;

import com.reciperegistry.Entity.Ingredient;
import com.reciperegistry.Repository.CategoryRepository;
import com.reciperegistry.Repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Ingredient> getAllIngredients() {
        CustomLogService.serviceLog("getAllIngredients()", "IngredientService");

        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredientList::add);
        return this.getSortedIngredientList(ingredientList);
    }

    private String getCategoryName(Ingredient ingredient) {
        CustomLogService.serviceLog("getCategoryName()", "IngredientService");

        return categoryRepository.findById(ingredient.getQuantityType()).get().getName();
    }

    public List<Ingredient> getIngredientsByRecipeId(Integer id) {
        CustomLogService.serviceLog("getIngredientsByRecipeId()", "IngredientService");

        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientRepository.findByRecipeId(id).forEach(ingredient -> {
            ingredient.setQuantityTypeName(this.getCategoryName(ingredient));
            ingredientList.add(ingredient);
        });
        return this.getSortedIngredientList(ingredientList);
    }

    private List<Ingredient> getSortedIngredientList(List<Ingredient> ingredients) {
        CustomLogService.serviceLog("getSortedIngredientList()", "IngredientService");

        return ingredients.stream()
                .sorted(Comparator.comparing(ingredient -> ingredient.getName().toLowerCase())).collect(Collectors.toList());
    }

    public Ingredient getIngredientById(Integer id) {
        CustomLogService.serviceLog("getIngredientById()", "IngredientService");

        return ingredientRepository.findById(id).get();
    }

    public void deleteIngredientById(Integer id) {
        CustomLogService.serviceLog("deleteIngredientById()", "IngredientService");

        ingredientRepository.deleteById(id);
    }

    public void updateIngredient(Ingredient ingredient) {
        CustomLogService.serviceLog("updateIngredient()", "IngredientService");

        ingredientRepository.save(ingredient);
    }

    public void insertIngredient(Ingredient ingredient) {
        CustomLogService.serviceLog("insertIngredient()", "IngredientService");

        ingredientRepository.save(ingredient);
    }

    public void insertIngredients(List<Ingredient> ingredients) {
        CustomLogService.serviceLog("insertIngredients()", "IngredientService");

        ingredientRepository.saveAll(ingredients);
    }
}
