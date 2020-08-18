package br.com.vinicius.creditcard.model;

import br.com.vinicius.creditcard.exceptions.ClientErrorException;

public class PersonClientFallback implements PersonClient {
    @Override
    public PersonModel getClientById(Long clienteId) {
        throw new ClientErrorException();
    }
}
