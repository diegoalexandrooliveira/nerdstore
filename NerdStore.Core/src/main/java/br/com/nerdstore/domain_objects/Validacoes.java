package br.com.nerdstore.domain_objects;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Validacoes {

    public static void vazioOuNulo(String valor, String mensagem) {
        if (Objects.isNull(valor) || valor.isBlank()) {
            throw new DomainException(mensagem);
        }
    }

    public static void menorOuIgual(BigDecimal valor, BigDecimal minimo, String mensagem) {
        if (Objects.isNull(valor) || valor.compareTo(minimo) <= 0) {
            throw new DomainException(mensagem);
        }
    }

    public static void nulo(Object valor, String mensagem) {
        if (Objects.isNull(valor)) {
            throw new DomainException(mensagem);
        }
    }

}
