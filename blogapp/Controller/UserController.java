package com.example.blogapp.Controller;

import com.example.blogapp.Model.Users;
import com.example.blogapp.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/getUser")
    public ResponseEntity getUser(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }
    @PostMapping("/addUser")
    public ResponseEntity addUser(@RequestBody@Valid Users users, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.addUser(users);
        return ResponseEntity.status(HttpStatus.OK).body("User add");
    }
    @PutMapping("/updateUser/{id}")
    public ResponseEntity updateUsers(@PathVariable Integer id,@RequestBody@Valid Users users,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        userService.updateUser(id, users);
        return ResponseEntity.status(HttpStatus.OK).body("User Updated");
    }
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body("User Deleted");
    }
    @GetMapping("/Check/{email}/{password}")
    public ResponseEntity check(@PathVariable String email ,@PathVariable String password){
        return ResponseEntity.status(HttpStatus.OK).body(userService.check(email, password));
    }
}
