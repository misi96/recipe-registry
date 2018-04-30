package com.reciperegistry.Service;

import com.reciperegistry.Entity.Category;
import com.reciperegistry.Models.RecipeStatistics;
import com.reciperegistry.Repository.CategoryRepository;
import com.reciperegistry.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for recipe statistics related operations.
 *
 * @author Szatmári Mihály
 */
@Service
public class StatisticsService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Calls the {@link RecipeRepository#findByCategory(Integer)} method from {@link RecipeRepository}
     * and {@link StatisticsService#getStatistics()} then returns a list of recipe categories and the
     * related number of recipes.
     *
     * @return a list of recipe statistics
     */
    public List<RecipeStatistics> getStatistics() {
        CustomLogService.serviceLog("getStatistics()", "StatisticsService");

        List<RecipeStatistics> recipeStatisticsList = new ArrayList<>();
        List<Category> categoryList = this.getRecipeCategories();

        categoryList.forEach(category -> {
            Integer recipeListSize;
            recipeListSize = recipeRepository.findByCategory(category.getId()).size();
            recipeStatisticsList.add(new RecipeStatistics(category.getName(), recipeListSize));
        });

        return recipeStatisticsList;
    }

    /**
     * Calls the {@link CategoryRepository#findByType(String)} method from {@link CategoryRepository}
     * and returns a list of recipe categories.
     *
     * @return a list of recipe categories
     */
    private List<Category> getRecipeCategories() {
        CustomLogService.serviceLog("getRecipeCategories()", "StatisticsService");

        List<Category> categoryList = new ArrayList<>();
        this.categoryRepository.findByType("RECIPE").forEach(category -> {
            categoryList.add(category);
        });
        return categoryList;
    }
}
