package br.com.vinicius.creditcard.model;

import br.com.vinicius.creditcard.configuration.PersonClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CLIENT", configuration = PersonClientConfiguration.class)
public interface PersonClient {

    @GetMapping("/cliente/{clienteId}")
    PersonModel getClientById(@PathVariable Long clienteId);

}
