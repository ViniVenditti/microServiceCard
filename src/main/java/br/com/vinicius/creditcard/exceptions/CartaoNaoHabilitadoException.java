package br.com.vinicius.creditcard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE, reason = "Cartão não habilitado para compra")
public class CartaoNaoHabilitadoException extends RuntimeException {
}
