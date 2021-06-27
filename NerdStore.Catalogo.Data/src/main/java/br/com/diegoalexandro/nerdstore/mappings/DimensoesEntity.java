package br.com.diegoalexandro.nerdstore.mappings;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
@Getter
@Setter
public class DimensoesEntity {

    private BigDecimal altura;

    private BigDecimal largura;

    private BigDecimal profundidade;
}
