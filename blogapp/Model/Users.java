package com.example.blogapp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "user name should not be empty")
    @Size(min = 3,max = 10,message = "user name length must be more than 3 and less than 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String username;
    @NotEmpty(message = " email should not be empty")
    @Email(message = "please enter valid email")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty
    @Size (min = 8 ,max = 10,message = "user name length must be more than 3 and less than 10")
    @Column(columnDefinition = "varchar(10) not null ")
    private String password;
    @Column(columnDefinition = "Date")
    private LocalDate registration_date;

}
