package br.com.vinicius.creditcard.service;

import br.com.vinicius.creditcard.entity.CardEntity;
import br.com.vinicius.creditcard.exceptions.CartaoExistenteException;
import br.com.vinicius.creditcard.exceptions.CartaoNotFoundException;
import br.com.vinicius.creditcard.mapper.CardMapper;
import br.com.vinicius.creditcard.model.CardModel;
import br.com.vinicius.creditcard.model.PersonClient;
import br.com.vinicius.creditcard.model.PersonModel;
import br.com.vinicius.creditcard.repository.CardRepository;
import ch.qos.logback.core.layout.EchoLayout;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    private CardMapper mapper;
    private CardRepository cardRepository;

    public CardService(CardRepository cardRepository, CardMapper mapper) {
        this.cardRepository = cardRepository;
        this.mapper = mapper;
    }


    public CardModel createCard(CardEntity entity) {
        CardEntity newCard;
        Optional<CardEntity> cartao = cardRepository.findCardByNumber(entity.getNumber());
        if(cartao.isEmpty()) {
            newCard = cardRepository.save(entity);
            return mapper.to(newCard);
        } else
            throw new CartaoExistenteException();
    }

    public CardModel updateCard(String numero, CardModel cartao) {
        Optional<CardEntity> entity = cardRepository.findCardByNumber(numero);
        if(entity.isPresent()){
            CardEntity cardEntity = entity.get();
            cardEntity.setActive(cartao.isActive());
            CardEntity cartaoAtualizado = cardRepository.save(cardEntity);
            return mapper.to(cartaoAtualizado);
        } else
            throw new CartaoNotFoundException();
    }

    public CardModel findCard(Long cardId) {
        Optional<CardEntity> cartao = cardRepository.findById(cardId);
        if(cartao.isPresent())
            return mapper.to(cartao.get());
        throw new CartaoNotFoundException();
    }

    public boolean verifyCardHabilit(Long cardId) {
        Optional<CardEntity> card = cardRepository.findById(cardId);
        if (card.isPresent())
            return card.get().isActive();
        else
            throw new CartaoNotFoundException();
    }

    public String blockCardById(Long cardId) {
        Optional<CardEntity> cartao = cardRepository.findById(cardId);
        if (cartao.isPresent()) {
            CardEntity cardEntity = cartao.get();
            cardEntity.setActive(false);
            CardEntity cartaoAtualizado = cardRepository.save(cardEntity);
            return "Ok";
        } else
            throw new CartaoNotFoundException();
    }

}