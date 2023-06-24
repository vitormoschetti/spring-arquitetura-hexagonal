package br.com.hexagonal.domain.product.service;

import br.com.hexagonal.domain.product.entity.IProduct;
import br.com.hexagonal.domain.shared.service.IService;

import java.math.BigDecimal;

public interface IProductService extends IService {

    IProduct get(final String id);

    IProduct create(final String name, final BigDecimal price);

    void enable(final IProduct product);

    void disable(final IProduct product);

}
