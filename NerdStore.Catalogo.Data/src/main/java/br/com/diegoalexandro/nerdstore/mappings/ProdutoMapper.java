package br.com.diegoalexandro.nerdstore.mappings;

import br.com.diegoalexandro.nerdstore.Categoria;
import br.com.diegoalexandro.nerdstore.Dimensoes;
import br.com.diegoalexandro.nerdstore.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto produtoEntityToProduto(ProdutoEntity entity);

    ProdutoEntity produtoToProdutoEntity(Produto produto);

    Categoria categoriaEntityToCategoria(CategoriaEntity entity);

    CategoriaEntity categoriaToCategoriaEntity(Categoria categoria);

    Dimensoes dimensoesEntityToDimensoes(DimensoesEntity entity);

    DimensoesEntity dimensoesToDimensoesEntity(Dimensoes entity);
}
