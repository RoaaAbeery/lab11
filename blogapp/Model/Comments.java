package com.example.blogapp.Model;

import jakarta.persistence.*;
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
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = " post id not null")
    @Column(columnDefinition = "int not null")
    private Integer post_id;
    @NotNull(message = "user id not null")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @NotEmpty
    @Size(max = 50)
    @Column(columnDefinition = "varchar(50) not null")
    private String content;
    @Column(columnDefinition = "Date")
    private LocalDate comment_date;
//    @Column(columnDefinition = "varchar ")
//    private String bad_Comments;


}
