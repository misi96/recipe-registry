package com.reciperegistry.Service;

import com.reciperegistry.Entity.Category;
import com.reciperegistry.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for handling category related operations.
 *
 * @author Szatmári Mihály
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Calls the {@link CategoryRepository#findByType(String)} method from {@link CategoryRepository}
     * and returns a list of all recipe categories.
     *
     * @return a list of all recipe categories
     */
    public List<Category> getRecipeCategories() {
        CustomLogService.serviceLog("getRecipeCategories()", "CategoryService");

        List<Category> recipeTypeList = new ArrayList<>();
        this.categoryRepository.findByType("RECIPE").forEach(recipeTypeList::add);
        return recipeTypeList;
    }

    /**
     * Calls the {@link CategoryRepository#findByType(String)} method from {@link CategoryRepository}
     * and returns a list of all ingredient quantity types.
     *
     * @return a list of all ingredient quantity types
     */
    public List<Category> getIngredientQuantityTypes() {
        CustomLogService.serviceLog("getIngredientQuantityTypes()", "CategoryService");

        List<Category> quantityTypeList = new ArrayList<>();
        this.categoryRepository.findByType("INGREDIENT").forEach(quantityTypeList::add);
        return quantityTypeList;
    }
}
