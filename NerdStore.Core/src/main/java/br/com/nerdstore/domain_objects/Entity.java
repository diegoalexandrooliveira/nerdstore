package br.com.nerdstore.domain_objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode(of = "id")
public abstract class Entity {

    @Getter
    private final UUID id;

    protected Entity() {
        id = UUID.randomUUID();
    }
}
