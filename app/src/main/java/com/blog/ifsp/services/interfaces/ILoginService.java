package com.blog.ifsp.services.interfaces;

import java.util.Optional;

import com.blog.ifsp.models.Usuario;

public interface ILoginService {

    public Optional<Usuario> authUser(Usuario usuario);
    public Usuario createUser(Usuario usuario);
    
}
