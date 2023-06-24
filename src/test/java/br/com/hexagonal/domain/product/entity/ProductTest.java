package br.com.hexagonal.domain.product.entity;

import br.com.hexagonal.domain.product.enums.ProductStatus;
import br.com.hexagonal.domain.shared.exception.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    @DisplayName("should throw exception when try enable with price equal zero")
    void shouldThrowExceptionEnablePriceEqualZero() {

        final var domainException = Assertions.assertThrows(DomainException.class, () -> new Product(
                UUID.randomUUID().toString(),
                BigDecimal.ZERO
        ).enable());

        assertEquals(DomainException.class, domainException.getClass());
        assertEquals("The price must be greater than zero to enable the product", domainException.getMessage());

    }

    @Test
    @DisplayName("should enable when price greater than zero")
    void shouldEnablePriceGreaterThanZero() {

        final var product = new Product(
                UUID.randomUUID().toString(),
                BigDecimal.ONE
        );

        product.enable();

        assertEquals(ProductStatus.ENABLE.name(), product.getStatus());

    }

    @Test
    @DisplayName("should throw exception when try disable with price greater than zero")
    void shouldThrowExceptionDisablePriceGreaterThanZero() {

        final var domainException = Assertions.assertThrows(DomainException.class, () -> new Product(
                UUID.randomUUID().toString(),
                BigDecimal.TEN
        ).disable());

        assertEquals(DomainException.class, domainException.getClass());
        assertEquals("The price must be zero to disable the product", domainException.getMessage());

    }

    @Test
    @DisplayName("should disable when price equal zero")
    void shouldDisablePriceEqualZero() {

        final var product = new Product(
                UUID.randomUUID().toString(),
                BigDecimal.ZERO
        );

        product.disable();

        assertEquals(ProductStatus.DISABLE.name(), product.getStatus());

    }

    @Test
    @DisplayName("shoud return false when isValid")
    void shouldReturnFalseIsValid() {

        final var productInvalidId = Assertions.assertThrows(DomainException.class, () -> new Product("", BigDecimal.ONE));
        assertEquals(DomainException.class, productInvalidId.getClass());
        assertEquals("Name is required", productInvalidId.getMessage());

        final var productInvalidPrice = Assertions.assertThrows(DomainException.class, () -> new Product("id", new BigDecimal("-1")));
        assertEquals(DomainException.class, productInvalidPrice.getClass());
        assertEquals("Price must be greater or equal than zero", productInvalidPrice.getMessage());
    }

    @Test
    @DisplayName("shoud throw exception when changePrice")
    void shouldThrowExceptionWhenChangePrice() {

        final var product = new Product("id", new BigDecimal("10"));
        final var productInvalidPrice = Assertions.assertThrows(DomainException.class, () -> product.changePrice(new BigDecimal("-1")));

        assertEquals(DomainException.class, productInvalidPrice.getClass());
        assertEquals("Price must be greater or equal than zero", productInvalidPrice.getMessage());
    }


}
