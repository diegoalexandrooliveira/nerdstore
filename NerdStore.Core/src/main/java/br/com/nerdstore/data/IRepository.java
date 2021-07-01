package br.com.nerdstore.data;

import br.com.nerdstore.domain_objects.IAggregateRoot;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRepository<T extends IAggregateRoot> {

    List<T> recuperaTodos();

    T salvar(T entity);

    Optional<T> procuraPorId(UUID id);

}
