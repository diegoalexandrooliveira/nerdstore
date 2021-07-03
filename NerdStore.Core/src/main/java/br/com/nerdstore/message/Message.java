package br.com.nerdstore.message;

import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Message {

    private final String messageType;

    protected UUID aggregateId;

    protected Message() {
        messageType = this.getClass().getTypeName();
    }
}
