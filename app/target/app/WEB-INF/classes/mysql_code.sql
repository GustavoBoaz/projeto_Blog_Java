CREATE DATABASE db_blog;
USE db_blog;

DROP TABLE IF EXISTS tb_usuarios;
CREATE TABLE tb_usuarios (
  id_usuario int(10) NOT NULL AUTO_INCREMENT,
  nome_usuario varchar(30) NOT NULL,
  email_usuario varchar(30) NOT NULL,
  PRIMARY KEY (id_usuario)
);

DROP TABLE IF EXISTS tb_posts;
CREATE TABLE tb_posts (
  id_post int(10) NOT NULL AUTO_INCREMENT,
  descricao_post varchar(30) NOT NULL,
  cod_usuario int(10) NOT NULL,
  PRIMARY KEY (id_post),
  KEY fk_cod_usuario (cod_usuario),
  CONSTRAINT fk_post_cod_usuario FOREIGN KEY (cod_usuario) REFERENCES tb_usuarios (id_usuario) ON DELETE NO ACTION ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS tb_comentarios;
CREATE TABLE tb_comentarios (
  id_comentario int(10) NOT NULL AUTO_INCREMENT,
  comentario varchar(30) NOT NULL,
  cod_post int(10) NOT NULL,
  cod_usuario int(10) NOT NULL,
  PRIMARY KEY (id_comentario),
  KEY fk_cod_post (cod_post),
  KEY fk_cod_usuario (cod_usuario),
  CONSTRAINT fk_comentario_cod_post FOREIGN KEY (cod_post) REFERENCES tb_posts (id_post) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_comentario_cod_usuario FOREIGN KEY (cod_usuario) REFERENCES tb_usuarios (id_usuario) ON DELETE NO ACTION ON UPDATE NO ACTION
);