package com.example.blogapp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "post id should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer post_id;
    @NotEmpty(message = "category name should not empty")
    @Size(max = 10,min=3)
    @Column(columnDefinition = "varchar(10) not null")
    private String category_name;


}
