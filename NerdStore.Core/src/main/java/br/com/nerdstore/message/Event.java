package br.com.nerdstore.message;

import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
public class Event extends Message {

    private final ZonedDateTime dateTime;

    public Event() {
        dateTime = ZonedDateTime.now();
    }
}
