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

@WebServlet(urlPatterns = "/home.blog")
public class HomeServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 6027295501765703094L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        PostDAO dao;
        try {
            dao = new PostDAO();
            HomeService services = new HomeService(dao);

            request.setAttribute("name", request.getSession().getAttribute("session_user_name"));
            request.setAttribute("email", request.getSession().getAttribute("session_user_email"));
            request.setAttribute("id", request.getSession().getAttribute("session_user_id"));
            request.setAttribute("posts", services.retrieveAll());
            request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
