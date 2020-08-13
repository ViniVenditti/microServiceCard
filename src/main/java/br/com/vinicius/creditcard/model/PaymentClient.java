package br.com.vinicius.creditcard.model;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "PAYMENT")
public interface PaymentClient {

    @RequestMapping("/pagamento/{idCard}")
    List<PaymentModel> getExtract(@PathVariable Long id_card);

}
