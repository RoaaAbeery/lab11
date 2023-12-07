package com.example.blogapp.Repository;

import com.example.blogapp.Model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comments,Integer> {
    Comments findCommentsById(Integer id);
    @Query("select c from Comments c where c.post_id=?1")
    List<Comments> findCommentsByPost_id(Integer post_id);
    @Query("select c from Comments  c where c.post_id=?1 and c.user_id=?2")
     Comments findCommentsByPost_idAndUser_id(Integer post_id,Integer user_id);






//    @Query("select c from Comments c where c.content=?1")
//    Comments findCommentsByContent(String content);
}
