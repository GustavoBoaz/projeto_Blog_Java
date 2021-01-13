package com.blog.ifsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.blog.ifsp.dao.interfaces.IDAO;
import com.blog.ifsp.models.Comentario;
import com.blog.ifsp.utils.ConnectionFactory;

import org.apache.log4j.Logger;

public class ComentarioDAO implements IDAO<Comentario> {

    private static Logger log = Logger.getLogger(ComentarioDAO.class);

    private Connection con;

    public ComentarioDAO() throws ClassNotFoundException, SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    @Override
    public Optional<Comentario> get(long id) {
        Comentario bean = null;
        String sql = "SELECT * FROM tb_comentarios WHERE id_comentario = ?";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bean = new Comentario();
                bean.setId(Long.valueOf(rs.getInt(1)));
                bean.setComentario(rs.getString(2));
                bean.setIdPost(Long.valueOf(rs.getInt(3)));
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
    public List<Comentario> getAll() {
        Comentario bean = null;
        List<Comentario> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_comentarios";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bean = new Comentario();
                bean.setId(Long.valueOf(rs.getInt(1)));
                bean.setComentario(rs.getString(2));
                bean.setIdPost(Long.valueOf(rs.getInt(3)));
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
    public void save(Comentario comentario) {
        String sql = "INSERT INTO tb_comentarios(comentario, cod_post, cod_usuario) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, comentario.getComentario());
            stmt.setLong(2, comentario.getIdPost());
            stmt.setLong(3, comentario.getIdUsuario());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public void delete(Comentario comentario) {
        String sql = "DELETE FROM tb_comentarios WHERE id_comentario = ?";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, comentario.getId().intValue());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            log.error(ex);
        }
    }
    
}
