package com.reciperegistry.Controller;

import com.reciperegistry.Entity.Category;
import com.reciperegistry.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("recipe/list")
    public Collection<Category> getRecipeTypes() {
        return categoryService.getRecipeTypes();
    }

    @GetMapping("ingredient/list")
    public Collection<Category> getQuantityTypes() {
        return categoryService.getQuantityTypes();
    }
}