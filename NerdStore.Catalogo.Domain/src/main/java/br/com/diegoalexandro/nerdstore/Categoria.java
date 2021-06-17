package br.com.diegoalexandro.nerdstore;

import br.com.nerdstore.domain_objects.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Categoria extends Entity {

    private int codigo;

    private String nome;

    public Categoria(int codigo, String nome) {
        super();
        this.codigo = codigo;
        this.nome = nome;
    }
}
