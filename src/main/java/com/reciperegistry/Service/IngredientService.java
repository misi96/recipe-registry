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

/**
 * This class is responsible for handling ingredient related operations.
 *
 * @author Szatmári Mihály
 */
@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Calls the {@link IngredientRepository#findAll()} method from {@link IngredientRepository}
     * and returns a list of all ingredients.
     *
     * @return a list of all ingredients
     */
    public List<Ingredient> getAllIngredients() {
        CustomLogService.serviceLog("getAllIngredients()", "IngredientService");

        List<Ingredient> ingredientList = new ArrayList<>();
        this.ingredientRepository.findAll().forEach(ingredientList::add);

        return this.getSortedIngredientList(ingredientList);
    }

    /**
     * Calls the {@link IngredientRepository#findById(Object)} method from {@link IngredientRepository}
     * and returns the name of the ingredient quantity type.
     *
     * @param ingredient the existing ingredient
     * @return the name of the ingredient quantity type
     */
    private String getCategoryName(Ingredient ingredient) {
        CustomLogService.serviceLog("getCategoryName()", "IngredientService");

        return this.categoryRepository.findById(ingredient.getQuantityType()).get().getName();
    }

    /**
     * Calls the {@link IngredientRepository#findByRecipeId(Integer)} ()} method from {@link IngredientRepository},
     * sets the quantity type name and returns a list of ingredients by recipe id.
     *
     * @param id the id of the recipe
     * @return a list of ingredients by recipe id
     */
    public List<Ingredient> getIngredientsByRecipeId(Integer id) {
        CustomLogService.serviceLog("getIngredientsByRecipeId()", "IngredientService");

        List<Ingredient> ingredientList = new ArrayList<>();
        this.ingredientRepository.findByRecipeId(id).forEach(ingredient -> {
            ingredient.setQuantityTypeName(this.getCategoryName(ingredient));
            ingredientList.add(ingredient);
        });

        return this.getSortedIngredientList(ingredientList);
    }

    /**
     * Sorts a list of ingredients by name and returns the sorted list.
     *
     * @param ingredients the ingredients which should be sorted by name
     * @return a sorted list of ingredients by name
     */
    private List<Ingredient> getSortedIngredientList(List<Ingredient> ingredients) {
        CustomLogService.serviceLog("getSortedIngredientList()", "IngredientService");

        return ingredients.stream()
                .sorted(Comparator.comparing(ingredient -> ingredient.getName().toLowerCase())).collect(Collectors.toList());
    }

    /**
     * Calls the {@link IngredientRepository#findById(Object)} method from {@link IngredientRepository}
     * and returns an ingredient by id.
     *
     * @param id the id of the ingredient
     * @return an ingredient by id
     */
    public Ingredient getIngredientById(Integer id) {
        CustomLogService.serviceLog("getIngredientById()", "IngredientService");

        return this.ingredientRepository.findById(id).get();
    }

    /**
     * Calls the {@link IngredientRepository#deleteById(Object)} method from {@link IngredientRepository}
     * and deletes an ingredient by id from the database.
     *
     * @param id the id of the ingredient
     */
    public void deleteIngredientById(Integer id) {
        CustomLogService.serviceLog("deleteIngredientById()", "IngredientService");

        this.ingredientRepository.deleteById(id);
    }

    /**
     * Calls the {@link IngredientRepository#save(Object)} method from {@link IngredientRepository}
     * and updates an existing ingredient in the database.
     *
     * @param ingredient the existing ingredient
     */
    public void updateIngredient(Ingredient ingredient) {
        CustomLogService.serviceLog("updateIngredient()", "IngredientService");

        this.ingredientRepository.save(ingredient);
    }

    /**
     * Calls the {@link IngredientRepository#save(Object)} method from {@link IngredientRepository}
     * and inserts a new ingredient into the database.
     *
     * @param ingredient the new ingredient
     */
    public void insertIngredient(Ingredient ingredient) {
        CustomLogService.serviceLog("insertIngredient()", "IngredientService");

        this.ingredientRepository.save(ingredient);
    }

    /**
     * Calls the {@link IngredientRepository#saveAll(Iterable)} method from {@link IngredientRepository}
     * and inserts new ingredients into the database.
     *
     * @param ingredients the list of new ingredients
     */
    public void insertIngredients(List<Ingredient> ingredients) {
        CustomLogService.serviceLog("insertIngredients()", "IngredientService");

        this.ingredientRepository.saveAll(ingredients);
    }
}
