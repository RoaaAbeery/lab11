package com.example.blogapp.Repository;

import com.example.blogapp.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepsitory extends JpaRepository<Users,Integer> {
    Users findUsersById(Integer id);

    @Query("select u from Users u where u.email=?1 and u.password=?2")
    Users findUsersByEmailAndPassword(String email,String password);
}
