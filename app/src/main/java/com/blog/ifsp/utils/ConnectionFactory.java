package com.blog.ifsp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// import java.util.logging.Level;
// import java.util.logging.Logger;

// import com.blog.ifsp.dao.PostDAO;
// import com.blog.ifsp.models.Post;
// import com.blog.ifsp.models.Usuario;


public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/db_blog";
        String username = "root";
        String password = "root";
        
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    // public static void main(String[] args) {
    //     try {

    //         Post post = new Post("Quinto Post Do Blog Para test", (long) 1);
    //         PostDAO dao = new PostDAO();

    //         dao.save(post);

    //         Connection conn = ConnectionFactory.getConnection();
    //         System.out.println("SUCESSO NA CONECTION!");
    //     } catch (ClassNotFoundException ex) {
    //         System.out.println("ERRO CONECTION");
    //         Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    //     } catch (SQLException ex) {
    //         System.out.println("ERRO CONECTION");
    //         Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    // }
}