package br.com.diegoalexandro.nerdstore;

import java.util.UUID;

public class EstoqueService implements IEstoqueService {

    private final IProdutoRepository produtoRepository;

    public EstoqueService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void debitarEstoque(UUID idProduto, int quantidade) {
        Produto produto = produtoRepository.procuraPorId(idProduto).orElseThrow();
        produto.debitarEstoque(quantidade);
        produtoRepository.salvar(produto);
    }

    @Override
    public void reporEstoque(UUID idProduto, int quantidade) {
        Produto produto = produtoRepository.procuraPorId(idProduto).orElseThrow();
        produto.reporEstoque(quantidade);
        produtoRepository.salvar(produto);
    }
}
