package br.com.diegoalexandro.nerdstore;

import br.com.nerdstore.domain_objects.IAggregateRoot;
import br.com.nerdstore.domain_objects.Validacoes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Produto implements IAggregateRoot {

    private UUID id;

    private String nome;

    private String descricao;

    private boolean ativo;

    private BigDecimal valor;

    private ZonedDateTime dataCadastro;

    private String imagem;

    private int quantidadeEstoque;

    private Categoria categoria;

    private Dimensoes dimensoes;

    public Produto(UUID id, String nome, String descricao, boolean ativo, BigDecimal valor, ZonedDateTime dataCadastro, String imagem, int quantidadeEstoque, Categoria categoria, Dimensoes dimensoes) {
        Validacoes.vazioOuNulo(nome, "Nome não pode ser vazio.");
        Validacoes.vazioOuNulo(descricao, "Descrição não pode ser vazio.");
        Validacoes.menorOuIgual(valor, BigDecimal.ZERO, "Valor do produto deve ser maior que 0.");
        Validacoes.nulo(dimensoes, "Dimensões não pode ser nulo.");
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.imagem = imagem;
        this.quantidadeEstoque = quantidadeEstoque;
        this.categoria = categoria;
        this.dimensoes = dimensoes;
    }

    public void debitarEstoque(int quantidade) {
        quantidadeEstoque = quantidadeEstoque - quantidade;
        if (quantidadeEstoque < 0) {
            quantidadeEstoque = quantidadeEstoque + quantidade;
            throw new IllegalStateException("Produto não possui estoque suficiente.");
        }
    }

    public void reporEstoque(int quantidade) {
        quantidadeEstoque = quantidadeEstoque + quantidade;
    }
}
