package com.example.blogapp.Controller;

import com.example.blogapp.Model.Categories;
import com.example.blogapp.Model.Comments;
import com.example.blogapp.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/getCate")
    public ResponseEntity getCate(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCate());
    }
    @PostMapping("/addCate")
    public ResponseEntity addCate(@RequestBody @Valid Categories categories, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        categoryService.addCate(categories);
        return ResponseEntity.status(HttpStatus.OK).body("Category add");
    }
    @PutMapping("/updateCate/{id}")
    public ResponseEntity updateCate(@PathVariable Integer id,@RequestBody @Valid Categories categories,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        categoryService.updateCate(id, categories);
        return ResponseEntity.status(HttpStatus.OK).body("Category Updated");
    }
    @DeleteMapping("/deleteCate/{id}")
    public ResponseEntity deleteCate(@PathVariable Integer id){
        categoryService.deleteCate(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted");
    }
    @GetMapping("/getByName/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getByName(name));
    }
    @GetMapping("/getByid/{id}")
    public ResponseEntity getByid(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getById(id));
    }
}
