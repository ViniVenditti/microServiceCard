package br.com.vinicius.creditcard.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CardModel {

    private Long id;

    @JsonProperty(value = "numero")
    private String number;

    @JsonProperty("clienteId")
    private Long customerId;

    @JsonProperty("ativo")
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
