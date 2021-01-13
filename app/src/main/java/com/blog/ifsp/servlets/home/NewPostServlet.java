package com.blog.ifsp.servlets.home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.ifsp.dao.PostDAO;
import com.blog.ifsp.models.Post;
import com.blog.ifsp.services.HomeService;

@WebServlet(urlPatterns = "/new.post.blog")
public class NewPostServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 5765409668414475450L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String comentario = request.getParameter("postagem");
        String idUsuario = request.getParameter("id_usuario");
        Post newPost = new Post(comentario, Long.valueOf(idUsuario).longValue());
        PostDAO dao;
        try {
            dao = new PostDAO();
            HomeService services = new HomeService(dao);
            services.saveNewPost(newPost);
            response.sendRedirect("/app/home.blog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
