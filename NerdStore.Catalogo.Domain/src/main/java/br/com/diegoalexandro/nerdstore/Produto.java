package br.com.diegoalexandro.nerdstore;

import br.com.nerdstore.domain_objects.Entity;
import br.com.nerdstore.domain_objects.IAggregateRoot;
import br.com.nerdstore.domain_objects.Validacoes;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Produto extends Entity implements IAggregateRoot {

    private String nome;

    private String descricao;

    private boolean ativo;

    private BigDecimal valor;

    private ZonedDateTime dataCadastro;

    private String imagem;

    private int quantidadeEstoque;

    private Categoria categoria;

    private Dimensoes dimensoes;

    public Produto(String nome, String descricao, boolean ativo, BigDecimal valor, ZonedDateTime dataCadastro, String imagem, Dimensoes dimensoes) {
        super();
        Validacoes.vazioOuNulo(nome, "Nome não pode ser vazio.");
        Validacoes.vazioOuNulo(descricao, "Descrição não pode ser vazio.");
        Validacoes.menorOuIgual(valor, BigDecimal.ZERO, "Valor do produto deve ser maior que 0.");
        Validacoes.nulo(dimensoes, "Dimensões não pode ser nulo.");
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
        this.valor = valor;
        this.dataCadastro = dataCadastro;
        this.imagem = imagem;
        this.dimensoes = dimensoes;
    }
}