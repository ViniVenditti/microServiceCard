package br.com.vinicius.creditcard.repository;

import br.com.vinicius.creditcard.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardRepository extends JpaRepository<CardEntity, Long> {

    Optional<CardEntity> findCardByNumber(String numero);

}
