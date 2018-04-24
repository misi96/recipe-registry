package com.reciperegistry.Service;

import com.reciperegistry.Entity.Category;
import com.reciperegistry.Models.RecipeStatistics;
import com.reciperegistry.Repository.CategoryRepository;
import com.reciperegistry.Repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<RecipeStatistics> getStatistics() {
        CustomLogService.serviceLog("getStatistics()", "StatisticsService");

        List<RecipeStatistics> recipeStatisticsList = new ArrayList<>();
        List<Category> categoryList = this.getRecipeCategories();

        categoryList.forEach(category -> {
            Integer recipeListSize;
            recipeListSize = recipeRepository.findByType(category.getId()).size();
            recipeStatisticsList.add(new RecipeStatistics(category.getName(), recipeListSize));
        });

        return recipeStatisticsList;
    }

    private List<Category> getRecipeCategories() {
        CustomLogService.serviceLog("getRecipeCategories()", "StatisticsService");

        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findByParent("RECIPE").forEach(category -> {
            categoryList.add(category);
        });
        return categoryList;
    }
}
