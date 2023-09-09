CREATE TABLE IF NOT EXISTS tb_comentarios (
  idComentario BIGINT NOT NULL AUTO_INCREMENT,
  texto TEXT,
  dataDeCriacao DATE,
  idAutor BIGINT NOT NULL,
  idPost BIGINT NOT NULL,
  FOREIGN KEY (idAutor) REFERENCES tb_usuarios(idUsuario),
  FOREIGN KEY (idPost) REFERENCES tb_posts(idPost),
  PRIMARY KEY (idComentario)
);