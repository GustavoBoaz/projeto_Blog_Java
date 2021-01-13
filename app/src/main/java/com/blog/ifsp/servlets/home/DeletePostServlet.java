package com.blog.ifsp.servlets.home;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.ifsp.dao.PostDAO;
import com.blog.ifsp.services.HomeService;

@WebServlet(urlPatterns = "/delete.post.blog")
public class DeletePostServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = -8974269613941373620L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String id = request.getParameter("delete_post");
        PostDAO dao;
        try {
            dao = new PostDAO();
            HomeService services = new HomeService(dao);
            services.deletePostById(Long.valueOf(id).longValue());
            response.sendRedirect("/app/home.blog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
