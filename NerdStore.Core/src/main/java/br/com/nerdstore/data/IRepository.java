package br.com.nerdstore.data;

import br.com.nerdstore.domain_objects.IAggregateRoot;

import java.util.List;

public interface IRepository<T extends IAggregateRoot> {

    List<T> recuperaTodos();

    T salvar(T entity);

}
