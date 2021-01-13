package com.blog.ifsp.servlets.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.ifsp.dao.UsuarioDAO;
import com.blog.ifsp.models.Usuario;
import com.blog.ifsp.services.LoginService;

@WebServlet(urlPatterns = "/login.blog")
public class LoginServlet extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 7868567513329408385L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		Usuario usuario = new Usuario(name, email);
		UsuarioDAO dao;

		try {
			dao = new UsuarioDAO();
			LoginService serviceLogin = new LoginService(dao);

			if (serviceLogin.authUser(usuario).isPresent()) {
				request.getSession().setAttribute("session_user_email", email);
				request.getSession().setAttribute("session_user_name", name);
				request.getSession().setAttribute("session_user_id", serviceLogin.authUser(usuario).get().getId());
				response.sendRedirect("/app/home.blog");
			} else {
				serviceLogin.createUser(usuario);
				request.getSession().setAttribute("session_user_email", email);
				request.getSession().setAttribute("session_user_name", name);
				request.getSession().setAttribute("session_user_id", serviceLogin.authUser(usuario).get().getId());
				response.sendRedirect("/app/home.blog");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}