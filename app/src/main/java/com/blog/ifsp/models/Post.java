package com.blog.ifsp.models;

public class Post {

    private Long id;
    private String descricao;
    private Long idUsuario;

    public Post() {
    }

    public Post(String descricao, Long idUsuario) {
        this.setDescricao(descricao);
        this.setIdUsuario(idUsuario);
    }

    public Post(Long id, String descricao, Long idUsuario) {
        this.setId(id);
        this.setDescricao(descricao);
        this.setIdUsuario(idUsuario);
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "Post = { "+
                "id: "+ this.getId() +
                ", descricao: "+ this.getDescricao() +
                ", idUsuario: "+ this.getIdUsuario() +
                "}";
    }
}
