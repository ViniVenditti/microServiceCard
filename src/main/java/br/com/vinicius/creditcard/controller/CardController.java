package br.com.vinicius.creditcard.controller;

import br.com.vinicius.creditcard.mapper.CardMapper;
import br.com.vinicius.creditcard.model.CardDTO;
import br.com.vinicius.creditcard.model.CardModel;
import br.com.vinicius.creditcard.model.PersonClient;
import br.com.vinicius.creditcard.model.PersonModel;
import br.com.vinicius.creditcard.service.CardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cartao")
public class CardController {

    private CardMapper mapper;
    private CardService service;
    private PersonClient personClient;

    public CardController(PersonClient personClient, CardMapper mapper, CardService service) {
        this.mapper = mapper;
        this.service = service;
        this.personClient = personClient;
    }

    @GetMapping("/{numero}/{clienteId}")
    public ResponseEntity<CardModel> createCard(@PathVariable String numero, @PathVariable Long clienteId) {
        CardModel card = new CardModel();
        card.setNumber(numero);
        PersonModel clientById = personClient.getClientById(clienteId);
        card.setCustomerId(clientById.getId());

        CardModel newCard = service.createCard(mapper.from(card));
        return ResponseEntity.status(HttpStatus.CREATED).body(newCard);
    }

    @PutMapping(value = "/{numero}")
    public ResponseEntity<CardModel> atualizarCartao(@PathVariable String numero, @RequestBody @Valid CardModel cardModel) {
        CardModel cartao = service.updateCard(numero, cardModel);
        return ResponseEntity.status(HttpStatus.OK).body(cartao);
    }

    @GetMapping(value = "/{cardId}")
    public CardDTO getCard(@PathVariable Long cardId) {
        CardModel cartao = service.findCard(cardId);
        CardDTO dto = mapper.mapperdto(cartao);
        return dto;
    }

    @GetMapping(value = "/blockCard/{cardId}")
    public String blockCard(@PathVariable Long cardId){
        return service.blockCardById(cardId);
    }

    @GetMapping(value = "/valid/{cardId}")
    public boolean verifyCard(@PathVariable Long cardId) {
        return service.verifyCardHabilit(cardId);
    }
}
