package com.blog.ifsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.blog.ifsp.dao.interfaces.IDAO;
import com.blog.ifsp.models.Usuario;
import com.blog.ifsp.utils.ConnectionFactory;

import org.apache.log4j.Logger;

public class UsuarioDAO implements IDAO<Usuario> {

    private static Logger log = Logger.getLogger(UsuarioDAO.class);

    private Connection con;
    
    public UsuarioDAO() throws ClassNotFoundException, SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    @Override
    public Optional<Usuario> get(long id) {
        Usuario bean = null;
        String sql = "SELECT * FROM tb_usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bean = new Usuario();
                bean.setId(Long.valueOf(rs.getInt(1)));
                bean.setNome(rs.getString(2));
                bean.setEmail(rs.getString(3));
            }
            rs.close();
            return Optional.ofNullable(bean);
        } catch (SQLException ex) {
            log.error(ex);
        }
        return Optional.ofNullable(bean);
    }

    public Optional<Usuario> getByEmail(String email) {
        Usuario bean = null;
        String sql = "SELECT * FROM tb_usuarios WHERE email_usuario = ?";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                bean = new Usuario();
                bean.setId(Long.valueOf(rs.getInt(1)));
                bean.setNome(rs.getString(2));
                bean.setEmail(rs.getString(3));
            }
            rs.close();
            return Optional.ofNullable(bean);
        } catch (SQLException ex) {
            log.error(ex);
        }
        return Optional.ofNullable(bean);
    }

    @Override
    public List<Usuario> getAll() {
        Usuario bean = null;
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM tb_usuarios";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bean = new Usuario();
                bean.setId(Long.valueOf(rs.getInt(1)));
                bean.setNome(rs.getString(2));
                bean.setEmail(rs.getString(3));
                lista.add(bean);
            }
            rs.close();   
        } catch (SQLException ex) {
            log.error(ex);
        }
        return lista;
    }

    @Override
    public void save(Usuario usuario) {
        String sql = "INSERT INTO tb_usuarios(nome_usuario, email_usuario) VALUES (?, ?)";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public void delete(Usuario usuario){
        String sql = "DELETE FROM tb_usuarios WHERE id_usuario = ?";
        try {
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, usuario.getId().intValue());
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            log.error(ex);
        }
    }  
}