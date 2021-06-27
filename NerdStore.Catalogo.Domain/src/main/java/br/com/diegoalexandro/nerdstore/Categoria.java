package br.com.diegoalexandro.nerdstore;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Categoria {

    private UUID id;

    private int codigo;

    private String nome;

    public Categoria(UUID id, int codigo, String nome) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
    }
}
