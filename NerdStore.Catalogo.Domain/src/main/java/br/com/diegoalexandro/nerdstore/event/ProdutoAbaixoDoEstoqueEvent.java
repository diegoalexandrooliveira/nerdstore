package br.com.diegoalexandro.nerdstore.event;

import br.com.nerdstore.domain_objects.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProdutoAbaixoDoEstoqueEvent extends DomainEvent {

    private final int quantidadeRestante;

    public ProdutoAbaixoDoEstoqueEvent(UUID aggregateId, int quantidadeRestante) {
        super(aggregateId);
        this.quantidadeRestante = quantidadeRestante;
    }
}
