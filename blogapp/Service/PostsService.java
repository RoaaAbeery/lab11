package com.example.blogapp.Service;

import com.example.blogapp.ApiException.ApiException;
import com.example.blogapp.Model.Posts;
import com.example.blogapp.Model.Users;
import com.example.blogapp.Repository.PostsRepository;
import com.example.blogapp.Repository.UserRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepository postsRepository;
    private final UserService userService;
    private final UserRepsitory userRepsitory;
    public List<Posts> getPost(){
        return postsRepository.findAll();
    }
//    public void addPost(Posts posts){
//        for (int i = 0; i < userService.getUsers().size(); i++) {
//            if(userService.getUsers().get(i).getId().equals(getPost().get(i).getUser_id())){
//                postsRepository.save(posts);
//            }
//            else {
//                throw new ApiException("user id not equal");
//            }
//        }
//    }
    public  void addPost(Posts posts){
        Users users=userRepsitory.findUsersById(posts.getUser_id());
        if(users==null){
            throw new ApiException("user id not found");
        }
       postsRepository.save(posts);
    }





//    public void updatePost(Integer id,Posts posts) {
//        for (int i = 0; i < userService.getUsers().size(); i++) {
//            if (userService.getUsers().get(i).getId().equals(getPost().get(i).getUser_id())) {
//                for (int j = 0; j < getPost().size(); j++) {
//                    if (getPost().get(j).getId().equals(id)) {
//                        Posts oldPost = postsRepository.findPostsById(id);
//                        oldPost.setTitle(posts.getTitle());
//                        oldPost.setContent(posts.getContent());
//                        oldPost.setPublication_date(posts.getPublication_date());
//                        postsRepository.save(oldPost);
//                    } else {
//                        throw new ApiException("user id not found");
//                    }
//                }
//            }
//        }
//    }
    public void updatePost(Integer id,Posts posts){
        Posts oldPost=postsRepository.findPostsById(id);
        Users oldUser=userRepsitory.findUsersById(posts.getUser_id());
        if(oldPost==null){
            throw new ApiException("post id not found");
        }
        if(oldUser==null){
            throw new ApiException("user id not found");
        }
                        oldPost.setTitle(posts.getTitle());
                        oldPost.setContent(posts.getContent());
                        oldPost.setPublication_date(posts.getPublication_date());
                        postsRepository.save(oldPost);
    }
public void deletePost(Integer id){
        Posts posts=postsRepository.findPostsById(id);
        if(posts==null){
            throw new ApiException("id not found");
        }
        postsRepository.delete(posts);
    }
    public Posts getUser(Integer userId){
       Posts posts=postsRepository.findPostsByUser_id(userId);
        if(posts==null){
            throw new ApiException("id not found");
        }
        return posts;
    }
    public Posts getTitle(String title){
        Posts posts=postsRepository.findPostsByTitle(title);
        if(posts==null){
            throw new ApiException("title not found");
        }
        return posts;
    }
    public List<Posts> getPuser(Integer user_id,String status){
        List<Posts> posts=postsRepository.findPostsByUser_idsAndStatus(user_id, status);
        if(posts==null){
            throw new ApiException("not found");
        }
        return posts;
    }

}