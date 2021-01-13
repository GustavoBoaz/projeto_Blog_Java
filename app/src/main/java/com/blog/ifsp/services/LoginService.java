package com.blog.ifsp.services;

import java.util.Optional;

import com.blog.ifsp.dao.UsuarioDAO;
import com.blog.ifsp.models.Usuario;
import com.blog.ifsp.services.interfaces.ILoginService;

public class LoginService implements ILoginService {
    
    private UsuarioDAO dao;

    public LoginService(UsuarioDAO dao) {
        this.dao = dao;
    }

    //Auth
    @Override
    public Optional<Usuario> authUser(Usuario usuario){
        Optional<Usuario> oldUser = dao.getByEmail(usuario.getEmail());
        if (oldUser.isPresent()) {
            return oldUser;
        } else {
            return null;
        }
    }

    //Create
    @Override
    public Usuario createUser(Usuario usuario){
        dao.save(usuario);
        return usuario;
    }

}
