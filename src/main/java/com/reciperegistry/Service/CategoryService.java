package com.reciperegistry.Service;

import com.reciperegistry.Entity.Category;
import com.reciperegistry.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Collection<Category> getRecipeTypes() {
        List<Category> recipeTypeList = new ArrayList<>();
        categoryRepository.findByParent("RECIPE").forEach(recipeTypeList::add);
        return recipeTypeList;
    }

    public Collection<Category> getQuantityTypes() {
        List<Category> quantityTypeList = new ArrayList<>();
        categoryRepository.findByParent("INGREDIENT").forEach(quantityTypeList::add);
        return quantityTypeList;
    }
}
