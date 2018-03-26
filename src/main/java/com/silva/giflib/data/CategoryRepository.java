package com.silva.giflib.data;

import com.silva.giflib.model.Category;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryRepository {

    private static final List<Category> ALL_CATEGORIES = Arrays.asList(
      new Category(1, "Hot"),
      new Category(2, "Trending"),
      new Category(3, "Fresh")
    );

    public List<Category> getAllCategories () {
        return ALL_CATEGORIES;
    }

    public Category findById(int id){
        for (Category category: ALL_CATEGORIES){
            if (category.getId() == id){
                return category;
            }
        }
        return null;
    }
}
