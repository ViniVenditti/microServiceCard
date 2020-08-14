package br.com.vinicius.creditcard.decoder;

import br.com.vinicius.creditcard.exceptions.ClientNotFound;
import feign.Response;
import feign.codec.ErrorDecoder;

public class PersonClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() == 404) {
            return new ClientNotFound();
        }
        return errorDecoder.decode(methodKey, response);
    }
}
