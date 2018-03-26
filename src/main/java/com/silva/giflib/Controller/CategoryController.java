package com.silva.giflib.Controller;

import com.silva.giflib.data.CategoryRepository;
import com.silva.giflib.data.GifRepository;
import com.silva.giflib.model.Category;
import com.silva.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by sergiosilva on 3/19/18.
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap){
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }

    @RequestMapping("/category/{id}")
    public String category(@PathVariable int id, ModelMap modelMap){
        Category  category = categoryRepository.findById(id);
        modelMap.put("category", category);

        List<Gif> gifs = gifRepository.findCategoryById(id);
        modelMap.put("gifs", gifs);

        return "category";
    }

}
