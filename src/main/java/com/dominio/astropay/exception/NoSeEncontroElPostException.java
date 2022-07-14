package com.dominio.astropay.exception;

public class NoSeEncontroElPostException extends RuntimeException{

  public NoSeEncontroElPostException(Long postId) {
    super("No se encontro el post con ID = " + postId);
  }
}
