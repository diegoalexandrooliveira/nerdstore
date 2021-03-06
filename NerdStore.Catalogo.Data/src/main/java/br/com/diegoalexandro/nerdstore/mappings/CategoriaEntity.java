package br.com.diegoalexandro.nerdstore.mappings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CategoriaEntity {

    @Id
    private UUID id;

    private int codigo;

    private String nome;
}
