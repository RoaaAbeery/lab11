package com.example.blogapp.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "title should not be empty")
    @Size(min = 4, max = 10,message = "title must be more than 4 and less than 10")
    @Column(columnDefinition = "varchar(10) not null")
    private String title;
    @NotEmpty(message = "content should not be empty")
    @Size(min =50,max = 200,message = "content must be more than 50 and less than 200")
    @Column(columnDefinition = "varchar(200) not null")
    private String content;
    @NotNull(message = "user id should not be null")
    @Column(columnDefinition = "int not null")
    private Integer user_id;
    @Column(columnDefinition = "Date ")
    private LocalDate publication_date;
//@Temporal(TemporalType.TIMESTAMP)
//@Column(name = "comment_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//private Date publication_date;
    @NotEmpty(message = "status should not be empty")
    @Pattern(regexp = "^(like|dislike)$",message = "status must be like or dislike")
    @Column(columnDefinition = "varchar(8) not null Check (status='like' or status='dislike') ")
    private String status;
}
