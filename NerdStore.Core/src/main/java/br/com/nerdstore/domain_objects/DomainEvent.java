package br.com.nerdstore.domain_objects;

import br.com.nerdstore.message.Event;

import java.util.UUID;

public class DomainEvent extends Event {

    public DomainEvent(UUID aggregateId) {
        this.aggregateId = aggregateId;
    }
}
