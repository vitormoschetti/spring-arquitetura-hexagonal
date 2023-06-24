package br.com.hexagonal.domain.product.service;

import br.com.hexagonal.domain.BaseTest;
import br.com.hexagonal.domain.product.entity.IProduct;
import br.com.hexagonal.domain.product.enums.ProductStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

public class ProductServiceTest extends BaseTest {

    private IProductService service;
    private IProduct product;


    @BeforeEach
    void setUp() {
        this.product = this.buildProduct();
        this.service = new ProductService(this.buildGenericProductPersistence(product));
    }


    @Test
    @DisplayName("should get product")
    void shouldGetProduct() {

        final var response = this.service.get(anyString());

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        assertEquals(product.getName(), response.getName());
        assertEquals(product.getPrice(), response.getPrice());

    }

    @Test
    @DisplayName("should save product")
    void shouldSaveProduct() {

        final var response = this.service.create("name", BigDecimal.ONE);

        assertNotNull(response);
        assertEquals(product.getId(), response.getId());
        assertEquals(product.getName(), response.getName());
        assertEquals(product.getPrice(), response.getPrice());

    }

    @Test
    @DisplayName("should enable product")
    void shouldEnableProduct() {

        this.service.enable(this.product);

        assertEquals(ProductStatus.ENABLE.name(), this.product.getStatus());

    }


    @Test
    @DisplayName("should disable product")
    void shouldDisableProduct() {

        this.product.changePrice(BigDecimal.ZERO);

        this.service.disable(this.product);

        assertEquals(ProductStatus.DISABLE.name(), this.product.getStatus());


    }

}
