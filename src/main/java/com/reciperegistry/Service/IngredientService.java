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
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientRepository.findAll().forEach(ingredientList::add);
        return this.getSortedIngredientList(ingredientList);
    }

    private String getCategoryName(Ingredient ingredient) {
        return categoryRepository.findById(ingredient.getQuantityType()).get().getName();
    }

    public List<Ingredient> getIngredientsByRecipeId(Integer id) {
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientRepository.findByRecipeId(id).forEach(ingredient -> {
            ingredient.setQuantityTypeName(this.getCategoryName(ingredient));
            ingredientList.add(ingredient);
        });
        return this.getSortedIngredientList(ingredientList);
    }

    private List<Ingredient> getSortedIngredientList(List<Ingredient> ingredients) {
        return ingredients.stream()
                .sorted(Comparator.comparing(ingredient -> ingredient.getName().toLowerCase())).collect(Collectors.toList());
    }

    public Ingredient getIngredientById(Integer id) {
        return ingredientRepository.findById(id).get();
    }

    public void deleteIngredientById(Integer id) {
        ingredientRepository.deleteById(id);
    }

    public void updateIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void insertIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    public void insertIngredients(List<Ingredient> ingredients) {
        ingredientRepository.saveAll(ingredients);
    }
}
