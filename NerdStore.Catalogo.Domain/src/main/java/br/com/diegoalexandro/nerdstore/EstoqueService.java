package br.com.diegoalexandro.nerdstore;

import br.com.diegoalexandro.nerdstore.event.ProdutoAbaixoDoEstoqueEvent;
import br.com.nerdstore.message.EnviarEvento;

import java.util.UUID;

public class EstoqueService implements IEstoqueService {

    private final IProdutoRepository produtoRepository;
    private final EnviarEvento enviarEvento;

    public EstoqueService(IProdutoRepository produtoRepository, EnviarEvento enviarEvento) {
        this.produtoRepository = produtoRepository;
        this.enviarEvento = enviarEvento;
    }

    @Override
    public void debitarEstoque(UUID idProduto, int quantidade) {
        Produto produto = produtoRepository.procuraPorId(idProduto).orElseThrow();
        produto.debitarEstoque(quantidade);
        produtoRepository.salvar(produto);
        if (produto.getQuantidadeEstoque() < 10) {
            enviarEvento.enviar(new ProdutoAbaixoDoEstoqueEvent(produto.getId(), produto.getQuantidadeEstoque()));
        }
    }

    @Override
    public void reporEstoque(UUID idProduto, int quantidade) {
        Produto produto = produtoRepository.procuraPorId(idProduto).orElseThrow();
        produto.reporEstoque(quantidade);
        produtoRepository.salvar(produto);
    }
}
