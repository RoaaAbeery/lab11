package com.example.blogapp.Service;

import com.example.blogapp.ApiException.ApiException;
import com.example.blogapp.Model.Comments;
import com.example.blogapp.Model.Posts;
import com.example.blogapp.Model.Users;
import com.example.blogapp.Repository.CommentsRepository;
import com.example.blogapp.Repository.PostsRepository;
import com.example.blogapp.Repository.UserRepsitory;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentsService {
    private final CommentsRepository commentsRepository;
    private final PostsRepository postsRepository;
    private final UserRepsitory userRepsitory;
    public List<Comments> getComm(){
        return commentsRepository.findAll();
    }
    public void addcomm(Comments comments){
        Users users=userRepsitory.findUsersById(comments.getUser_id());
        Posts posts=postsRepository.findPostsById(comments.getPost_id());
        if(users==null){
            throw new ApiException("User id not found");
        }
        if(posts==null){
            throw new ApiException("Post id not found");
        }
        commentsRepository.save(comments);
    }
    public void updateComm(Integer id,Comments comments){
        Users users=userRepsitory.findUsersById(comments.getUser_id());
        Posts posts=postsRepository.findPostsById(comments.getPost_id());
        Comments oldComm=commentsRepository.findCommentsById(id);
        if(users==null){
            throw new ApiException("User id not found");
        }
        if(posts==null){
            throw new ApiException("Post id not found");
        }
        oldComm.setContent(comments.getContent());
        oldComm.setComment_date(comments.getComment_date());
        commentsRepository.save(oldComm);
    }
    public void deleteComm(Integer id){
        Comments comments=commentsRepository.findCommentsById(id);
        if(comments==null){
            throw new ApiException("id not found");
        }
        commentsRepository.delete(comments);

    }
    public List<Comments> getCommByPost(Integer post_id){
        List<Comments> comments=commentsRepository.findCommentsByPost_id(post_id);
        if(comments==null){
            throw new ApiException("id not found");
        }
return comments;
    }

    public Comments commByUaP(Integer post_id,Integer user_id){
        Comments comments=commentsRepository.findCommentsByPost_idAndUser_id(post_id, user_id);
        if(comments==null){
            throw new ApiException("Comment not found");
        }
        return comments;
    }
//    public void deletcomm(String content){
//        Comments comments=commentsRepository.findCommentsByContent(content);
//        if(comments==null){
//            throw new ApiException("comment not found");
//        }
//        for (int i = 0; i <getComm().size() ; i++) {
//        if(getComm().get(i).equals(content)){
//            commentsRepository.delete(comments);
//        }
//        }
//    }
}
