package br.com.vinicius.creditcard.configuration;

import br.com.vinicius.creditcard.decoder.PersonClientDecoder;
import br.com.vinicius.creditcard.model.PersonClientFallback;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class PersonClientConfiguration {

    @Bean
    public ErrorDecoder getPersonClientDecoder() {
        return new PersonClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new PersonClientFallback(), RetryableException.class)
                .build();
        return Resilience4jFeign.builder(decorators);
    }

}
