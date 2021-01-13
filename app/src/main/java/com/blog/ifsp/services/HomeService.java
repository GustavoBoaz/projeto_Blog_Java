package com.blog.ifsp.services;

import java.util.List;

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



    
    
}
