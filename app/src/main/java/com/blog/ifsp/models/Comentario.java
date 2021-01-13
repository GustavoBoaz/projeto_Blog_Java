package com.blog.ifsp.models;

public class Comentario {

    private Long id;
    private String comentario;
    private Long idPost;
    private Long idUsuario;

    public Comentario() {
    }

    public Comentario(String comentario, Long idPost, Long idUsuario) {
        this.setComentario(comentario);
        this.setIdPost(idPost);
        this.setIdUsuario(idUsuario);
    }

    public Comentario(Long id, String comentario, Long idPost, Long idUsuario) {
        this.setId(id);
        this.setComentario(comentario);
        this.setIdPost(idPost);
        this.setIdUsuario(idUsuario);
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Comentario = { "+
                "id: "+ this.getId() +
                ", comentario: "+ this.getComentario() +
                ", idPost: "+ this.getIdPost() +
                ", idUsuario: "+ this.getIdUsuario() +
                "}";
    }
}
