package com.blog.ifsp.dao.interfaces;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    Optional<T> get(long id);
    
    List<T> getAll();
    
    void save(T t);
        
    void delete(T t);
}
