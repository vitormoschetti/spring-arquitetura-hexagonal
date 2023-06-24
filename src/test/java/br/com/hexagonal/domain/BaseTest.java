package br.com.hexagonal.domain;

import br.com.hexagonal.domain.product.entity.IProduct;
import br.com.hexagonal.domain.product.entity.Product;
import br.com.hexagonal.domain.product.persistence.IProductPersistence;

import java.math.BigDecimal;

public class BaseTest {

    protected IProduct buildProduct() {

        return new Product("name", BigDecimal.ONE);

    }

    protected IProductPersistence buildGenericProductPersistence(final IProduct product) {
        return new IProductPersistence() {
            @Override
            public IProduct get(final String s) {
                return product;
            }

            @Override
            public IProduct save(final IProduct param) {
                return product;
            }
        };
    }

}
