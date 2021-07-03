package br.com.nerdstore.message;

public class EnviarEvento {

    public <T extends Event> void enviar(T evento) {
        System.out.println("Enviando evento " + evento.toString());
    }
}
