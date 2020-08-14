package br.com.vinicius.creditcard.configuration;

import br.com.vinicius.creditcard.decoder.PersonClientDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PersonClientConfiguration {

    @Bean
    public ErrorDecoder getPersonClientDecoder() {
        return new PersonClientDecoder();
    }

}
