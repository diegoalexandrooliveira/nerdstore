package br.com.diegoalexandro.nerdstore;

import br.com.nerdstore.domain_objects.Validacoes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Dimensoes {

    private BigDecimal altura;

    private BigDecimal largura;

    private BigDecimal profundidade;

    public Dimensoes(BigDecimal altura, BigDecimal largura, BigDecimal profundidade) {
        Validacoes.menorOuIgual(altura, BigDecimal.ZERO, "Altura não pode ser menor que 0.");
        Validacoes.menorOuIgual(largura, BigDecimal.ZERO, "Largura não pode ser menor que 0.");
        Validacoes.menorOuIgual(profundidade, BigDecimal.ZERO, "Profundidade não pode ser menor que 0.");
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
    }
}
