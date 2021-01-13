package com.blog.ifsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.blog.ifsp.dao.interfaces.IDAO;
import com.blog.ifsp.models.Post;
import com.blog.ifsp.utils.ConnectionFactory;

import org.apache.log4j.Logger;

public class PostDAO implements IDAO<Post>{

    private static Logger log = Logger.getLogger(PostDAO.class);

    private Connection con;

    public PostDAO() throws ClassNotFoundException, SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    @Override
    public Optional<Post> get(long id) {
        Post bean = null;
        String sql = "SELECT * FROM tb_posts WHERE id_post = ?";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bean = new Post();
                bean.setId(Long.valueOf(rs.getInt(1)));
                bean.setDescricao(rs.getString(2));
                bean.setIdUsuario(Long.valueOf(rs.getInt(3)));
            }
            rs.close();
            return Optional.ofNullable(bean);
        } catch (SQLException ex) {
            log.error(ex);
        }
        return Optional.ofNullable(bean);
    }

    @Override
    public List<Post> getAll() {
        Post bean = null;
        List<Post> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_posts";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bean = new Post();
                bean.setId(Long.valueOf(rs.getInt(1)));
                bean.setDescricao(rs.getString(2));
                bean.setIdUsuario(Long.valueOf(rs.getInt(3)));
                lista.add(bean);
            }
            rs.close();   
        } catch (SQLException ex) {
            log.error(ex);
        }
        return lista;
    }

    @Override
    public void save(Post post) {
        String sql = "INSERT INTO tb_posts(descricao_post, cod_usuario) VALUES (?, ?)";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, post.getDescricao());
            stmt.setLong(2, post.getIdUsuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public void delete(Post post){
        String sql = "DELETE FROM tb_posts WHERE id_post = ?";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, post.getId().intValue());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            log.error(ex);
        }
    }  
}
