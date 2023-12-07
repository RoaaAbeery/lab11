package com.example.blogapp.Service;

import com.example.blogapp.ApiException.ApiException;
import com.example.blogapp.Model.Categories;
import com.example.blogapp.Model.Comments;
import com.example.blogapp.Model.Posts;
import com.example.blogapp.Model.Users;
import com.example.blogapp.Repository.CategoryRepository;
import com.example.blogapp.Repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final PostsRepository postsRepository;
    public List<Categories> getCate(){
        return categoryRepository.findAll();
    }
    public void addCate(Categories categories){
        Posts posts=postsRepository.findPostsById(categories.getPost_id());
        if(posts==null){
            throw new ApiException("Post id not found");
        }
      categoryRepository.save(categories);
    }
    public void updateCate(Integer id,Categories categories){
        Posts posts=postsRepository.findPostsById(categories.getPost_id());
        Categories oldCategories=categoryRepository.findCategoriesById(id);
        if(oldCategories==null){
            throw new ApiException("Category id not found");
        }
        if(posts==null){
            throw new ApiException("Post id not found");
        }
        oldCategories.setCategory_name(categories.getCategory_name());
        categoryRepository.save(oldCategories);

    }
    public void deleteCate(Integer id){
        Categories categories=categoryRepository.findCategoriesById(id);
        if(categories==null){
            throw new ApiException("id not found");
        }
        categoryRepository.delete(categories);

    }
    public List<Categories> getByName(String category_name){
        List<Categories> categories=categoryRepository.findCategoriesByCategory_name(category_name);
        if(categories==null){
            throw new ApiException(" category not found");
        }
        return categories;
    }
    public Categories getById(Integer id){
        Categories categories=categoryRepository.findCategoriesById(id);
        if (categories==null){
            throw new ApiException("id not found");
        }
        return categories;
    }
}
