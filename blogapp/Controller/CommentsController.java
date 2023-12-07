package com.example.blogapp.Controller;

import com.example.blogapp.Model.Comments;
import com.example.blogapp.Service.CommentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentsController {
    private final CommentsService commentsService;
    @GetMapping("/getComm")
    public ResponseEntity getComm(){
        return ResponseEntity.status(HttpStatus.OK).body(commentsService.getComm());
    }
    @PostMapping("/addComm")
    public ResponseEntity addComm(@RequestBody@Valid Comments comments, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        commentsService.addcomm(comments);
        return ResponseEntity.status(HttpStatus.OK).body("Comments add");
    }
    @PutMapping("/updateComm/{id}")
    public ResponseEntity updateComm(@PathVariable Integer id,@RequestBody @Valid Comments comments,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        commentsService.updateComm(id, comments);
        return ResponseEntity.status(HttpStatus.OK).body("Comment Updated");
    }
    @DeleteMapping("/deleteComm/{id}")
    public ResponseEntity deleteComm(@PathVariable Integer id){
        commentsService.deleteComm(id);
        return ResponseEntity.status(HttpStatus.OK).body("Comment deleted");
    }

    @GetMapping("/getCommByPost/{post_id}")
    public ResponseEntity getCommByPost(@PathVariable Integer post_id){
        return ResponseEntity.status(HttpStatus.OK).body(commentsService.getCommByPost(post_id));
    }
    @DeleteMapping("/deleteComm/{content}")
    public ResponseEntity deleteComm(@PathVariable String content){
        commentsService.deletcomm(content);
        return ResponseEntity.status(HttpStatus.OK).body("Bad Comment deleted");
    }
}
