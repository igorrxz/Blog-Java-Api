CREATE TABLE IF NOT EXISTS tb_posts (
  idPost BIGINT NOT NULL AUTO_INCREMENT,
  titulo VARCHAR(255) NOT NULL,
  conteudo TEXT,
  dataDeCriacao DATE,
  idAutor BIGINT NOT NULL,
  PRIMARY KEY (idPost)
);