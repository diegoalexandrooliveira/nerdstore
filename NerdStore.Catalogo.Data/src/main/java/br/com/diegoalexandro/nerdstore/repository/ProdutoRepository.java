package br.com.diegoalexandro.nerdstore.repository;

import br.com.diegoalexandro.nerdstore.IProdutoRepository;
import br.com.diegoalexandro.nerdstore.Produto;
import br.com.diegoalexandro.nerdstore.mappings.ProdutoEntity;
import br.com.diegoalexandro.nerdstore.mappings.ProdutoMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public interface ProdutoRepository extends IProdutoRepository, JpaRepository<ProdutoEntity, UUID> {

    @Override
    default Optional<Produto> procuraPorId(UUID id) {
        return procuraPorIdQuery(id).map(ProdutoMapper.INSTANCE::produtoEntityToProduto);
    }

    @Override
    default List<Produto> recuperaTodos() {
        List<ProdutoEntity> produtoEntities = recuperaTodosQuery();
        return produtoEntities
                .stream()
                .map(ProdutoMapper.INSTANCE::produtoEntityToProduto)
                .collect(Collectors.toList());
    }

    @Override
    default Produto salvar(Produto produto) {
        var entity = ProdutoMapper.INSTANCE.produtoToProdutoEntity(produto);
        return ProdutoMapper.INSTANCE.produtoEntityToProduto(save(entity));
    }

    @Query("select p from ProdutoEntity p inner join fetch p.categoria order by p.id")
    List<ProdutoEntity> recuperaTodosQuery();

    @Query("select p from ProdutoEntity p inner join fetch p.categoria where p.id = :id")
    Optional<ProdutoEntity> procuraPorIdQuery(UUID id);
}
