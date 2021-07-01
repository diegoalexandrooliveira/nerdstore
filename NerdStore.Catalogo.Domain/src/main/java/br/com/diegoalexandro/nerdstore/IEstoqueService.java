package br.com.diegoalexandro.nerdstore;

import java.util.UUID;

public interface IEstoqueService {


    void debitarEstoque(UUID idProduto, int quantidade);

    void reporEstoque(UUID idProduto, int quantidade);

}
