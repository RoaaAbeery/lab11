package com.example.blogapp.Repository;

import com.example.blogapp.Model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts,Integer> {
    Posts findPostsById(Integer id);

    @Query("select p from Posts p where p.user_id=?1")
    Posts findPostsByUser_id(Integer user_id);
    @Query("select p from Posts p where p.title=?1")
    Posts findPostsByTitle(String title);
    @Query("select p from Posts p where p.user_id=?1 and p.status=?2")
    List<Posts> findPostsByUser_idsAndStatus(Integer user_id,String status);
//    @Query("select p from Posts p where p.publication_date<:date")
//    List<Posts> findPostsByPublication_dateAfter(Date date);

}
