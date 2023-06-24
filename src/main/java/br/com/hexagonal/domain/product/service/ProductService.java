package br.com.hexagonal.domain.product.service;

import br.com.hexagonal.domain.product.entity.IProduct;
import br.com.hexagonal.domain.product.entity.Product;
import br.com.hexagonal.domain.product.persistence.IProductPersistence;
import br.com.hexagonal.domain.shared.service.BaseService;

import java.math.BigDecimal;

public class ProductService extends BaseService<IProductPersistence> implements IProductService {

    protected ProductService(final IProductPersistence persistence) {
        super(persistence);
    }

    @Override
    public IProduct get(final String id) {
        return this.persistence.get(id);
    }

    @Override
    public IProduct create(final String name, final BigDecimal price) {

        final var product = new Product(name, price);
        return this.persistence.save(product);
    }

    @Override
    public void enable(final IProduct product) {
        product.enable();
        this.persistence.save(product);
    }

    @Override
    public void disable(final IProduct product) {
        product.disable();
        this.persistence.save(product);
    }

}
