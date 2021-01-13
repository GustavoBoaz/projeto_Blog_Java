package com.blog.ifsp.services.interfaces;

import java.util.List;

import com.blog.ifsp.models.Post;

public interface IHomeService {
    
    public List<Post> retrieveAll();
    public void deletePostById(Long id);
    public void saveNewPost(Post post);
}
