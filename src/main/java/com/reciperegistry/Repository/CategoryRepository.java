package com.reciperegistry.Repository;

import com.reciperegistry.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {
    public List<Category> findByParent(String parent);
}
