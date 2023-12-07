package com.example.blogapp.Service;

import com.example.blogapp.ApiException.ApiException;
import com.example.blogapp.Model.Posts;
import com.example.blogapp.Model.Users;
import com.example.blogapp.Repository.UserRepsitory;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepsitory userRepsitory;

    public List<Users> getUsers(){
        return userRepsitory.findAll();
    }
    public void addUser(Users users){
        userRepsitory.save(users);
    }
    public void updateUser(Integer id,Users users){
        Users oldUser=userRepsitory.findUsersById(id);
        if(oldUser==null){
            throw new ApiException("User not found");
        }
        oldUser.setUsername(users.getUsername());
        oldUser.setEmail(users.getEmail());
        oldUser.setPassword(users.getPassword());
        oldUser.setRegistration_date(users.getRegistration_date());
        userRepsitory.save(oldUser);
    }
    public void deleteUser(Integer  id){
        Users oldUser=userRepsitory.findUsersById(id);
        if(oldUser==null){
            throw new ApiException("id not found");
        }
        userRepsitory.delete(oldUser);
    }
    public Users check(String email,String password){
        Users user=userRepsitory.findUsersByEmailAndPassword(email,password);
        if(user==null){
            throw new ApiException("User not found");
        }
        return user;
    }

}
