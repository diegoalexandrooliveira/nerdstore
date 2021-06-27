package br.com.diegoalexandro.nerdstore.mappings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProdutoEntity {

    @Id
    private UUID id;

    private String nome;

    private String descricao;

    private boolean ativo;

    private BigDecimal valor;

    private ZonedDateTime dataCadastro;

    private String imagem;

    private int quantidadeEstoque;

    @ManyToOne
    private CategoriaEntity categoria;

    @Embedded
    private DimensoesEntity dimensoes;
}
