package com.dominio.astropay.exception;

public class ErrorAlConsumirLaApiException extends RuntimeException {
  public ErrorAlConsumirLaApiException(String message, int code) {
    super(message + " Code : " + code);
  }
}
