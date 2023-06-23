package br.com.hexagonal.application.product;

import br.com.hexagonal.application.shared.DomainException;
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
                UUID.randomUUID().toString(),
                BigDecimal.ZERO
        ).enable());

        assertEquals(DomainException.class, domainException.getClass());
        assertEquals("The price must be greater than zero to enable the product", domainException.getMessage());

    }

    @Test
    @DisplayName("should throw exception when try enable with price less than zero")
    void shouldThrowExceptionEnablePriceLessThanZero() {

        final var domainException = Assertions.assertThrows(DomainException.class, () -> new Product(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                new BigDecimal("-1")
        ).enable());

        assertEquals(DomainException.class, domainException.getClass());
        assertEquals("The price must be greater than zero to enable the product", domainException.getMessage());

    }

    @Test
    @DisplayName("should when try enable with price greater than zero")
    void shouldEnablePriceGreaterThanZero() {

        final var product = new Product(
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                BigDecimal.ONE
        );

        product.enable();

        assertEquals(ProductStatus.ENABLE.name(), product.getStatus());

    }


}
