package com.reciperegistry.Repository;

import com.reciperegistry.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is the repository of the categories.
 *
 * @author Szatmári Mihály
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    /**
     * Returns a list of categories by type.
     *
     * @param type the type of the category
     * @return a list of categories by type
     */
    public List<Category> findByType(String type);
}
