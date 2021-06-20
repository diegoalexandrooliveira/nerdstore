package br.com.diegoalexandro.nerdstore;

import br.com.nerdstore.domain_objects.DomainException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DimensoesTest {

    @DisplayName("Deve criar um objeto Dimensões")
    @Test
    void testeCriacao() {
        Dimensoes dimensoes = new Dimensoes(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);

        assertNotNull(dimensoes);
        assertEquals(BigDecimal.ONE, dimensoes.getAltura());
        assertEquals(BigDecimal.ONE, dimensoes.getLargura());
        assertEquals(BigDecimal.ONE, dimensoes.getProfundidade());
    }

    @DisplayName("Não deve criar um objeto Dimensões sem altura")
    @Test
    void testeAltura() {
        DomainException domainException = assertThrows(DomainException.class, () -> new Dimensoes(null, BigDecimal.ONE, BigDecimal.ONE));
        assertEquals("Altura não pode ser menor que 0.", domainException.getMessage());
    }

    @DisplayName("Não deve criar um objeto Dimensões sem largura")
    @Test
    void testeLargura() {
        DomainException domainException = assertThrows(DomainException.class, () -> new Dimensoes(BigDecimal.ONE, null, BigDecimal.ONE));
        assertEquals("Largura não pode ser menor que 0.", domainException.getMessage());
    }

    @DisplayName("Não deve criar um objeto Dimensões sem profundidade")
    @Test
    void testeProfundidade() {
        DomainException domainException = assertThrows(DomainException.class, () -> new Dimensoes(BigDecimal.ONE, BigDecimal.ONE, null));
        assertEquals("Profundidade não pode ser menor que 0.", domainException.getMessage());
    }

    @DisplayName("Não deve criar um objeto Dimensões com altura inválida")
    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -10})
    void testeAlturaNegativa(double altura) {
        BigDecimal alturaBigDecimal = BigDecimal.valueOf(altura);
        DomainException domainException = assertThrows(DomainException.class, () -> new Dimensoes(alturaBigDecimal, BigDecimal.ONE, BigDecimal.ONE));
        assertEquals("Altura não pode ser menor que 0.", domainException.getMessage());
    }

    @DisplayName("Não deve criar um objeto Dimensões com largura inválida")
    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -10})
    void testeLarguraNegativa(double largura) {
        BigDecimal larguraBigDecimal = BigDecimal.valueOf(largura);
        DomainException domainException = assertThrows(DomainException.class, () -> new Dimensoes(BigDecimal.ONE, larguraBigDecimal, BigDecimal.ONE));
        assertEquals("Largura não pode ser menor que 0.", domainException.getMessage());
    }

    @DisplayName("Não deve criar um objeto Dimensões com profundidade inválida")
    @ParameterizedTest
    @ValueSource(doubles = {0, -1, -10})
    void testeProfundidadeNegativa(double profundidade) {
        BigDecimal profundidadeBigDecimal = BigDecimal.valueOf(profundidade);
        DomainException domainException = assertThrows(DomainException.class, () -> new Dimensoes(BigDecimal.ONE, BigDecimal.ONE, profundidadeBigDecimal));
        assertEquals("Profundidade não pode ser menor que 0.", domainException.getMessage());
    }

}