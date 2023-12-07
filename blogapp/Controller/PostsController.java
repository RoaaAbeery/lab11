package com.example.blogapp.Controller;

import com.example.blogapp.Model.Posts;
import com.example.blogapp.Model.Users;
import com.example.blogapp.Service.PostsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostsController {
    private final PostsService postsService;
    @GetMapping("/getPosts")
    public ResponseEntity getPost(){
        return ResponseEntity.status(HttpStatus.OK).body(postsService.getPost());
    }
    @PostMapping("/addPost")
    public ResponseEntity addPost(@RequestBody @Valid Posts posts, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        postsService.addPost(posts);
        return ResponseEntity.status(HttpStatus.OK).body("Post add");
    }
    @PutMapping("/updatePost/{id}")
    public ResponseEntity updatePosts(@PathVariable Integer id,@RequestBody@Valid Posts posts,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        postsService.updatePost(id, posts);
        return ResponseEntity.status(HttpStatus.OK).body("Post Updated");
    }
    @DeleteMapping("/deletePosts/{id}")
    public ResponseEntity deletePost(@PathVariable Integer id){
        postsService.deletePost(id);
        return ResponseEntity.status(HttpStatus.OK).body("Post Deleted");
    }
    @GetMapping("/getUser/{id}")
    public ResponseEntity getuser(@PathVariable Integer user_id){
        return ResponseEntity.status(HttpStatus.OK).body(postsService.getUser(user_id));
    }
    @GetMapping("/getTitle/{title}")
    public ResponseEntity getTitle(@PathVariable String title){
        return ResponseEntity.status(HttpStatus.OK).body(postsService.getTitle(title));
    }
    @GetMapping("/status/{user_id}/{status}")
    public ResponseEntity check(@PathVariable Integer user_id,@PathVariable String status){
     return ResponseEntity.status(HttpStatus.OK).body(postsService.getPuser(user_id, status));
    }
//    @GetMapping("/date/{user_id}/{date}")
//    public ResponseEntity getBydate(@PathVariable Integer user_id, @PathVariable Date date){
//        return ResponseEntity.status(HttpStatus.OK).body(postsService.date(date));
//    }
}
