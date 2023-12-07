package com.example.blogapp.Repository;

import com.example.blogapp.Model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categories,Integer> {
    Categories findCategoriesById(Integer id);

    @Query("select c from Categories c where c.category_name=?1")
        List<Categories> findCategoriesByCategory_name(String category_name);

}
