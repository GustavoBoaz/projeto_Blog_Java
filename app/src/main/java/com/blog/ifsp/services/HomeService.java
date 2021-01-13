package com.blog.ifsp.services;

import java.util.List;
import java.util.Optional;

import com.blog.ifsp.dao.PostDAO;
import com.blog.ifsp.models.Post;
import com.blog.ifsp.services.interfaces.IHomeService;

public class HomeService implements IHomeService {

    private PostDAO dao;

    public HomeService(PostDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<Post> retrieveAll() {
        List<Post> list = dao.getAll();
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

    @Override
    public void deletePostById(Long id) {
        Optional<Post> oldPost = dao.get(id);
        if (oldPost.isPresent()) {
            dao.delete(oldPost.get());
        }
    }

    @Override
    public void saveNewPost(Post post) {
        dao.save(post);
    }



    
    
}
