package br.com.vinicius.creditcard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Cartão já existente para esse cliente")
public class CartaoExistenteException extends RuntimeException {
}
