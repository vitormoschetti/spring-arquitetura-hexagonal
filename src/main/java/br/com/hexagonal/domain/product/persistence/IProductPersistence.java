package br.com.hexagonal.domain.product.persistence;

import br.com.hexagonal.domain.product.entity.IProduct;
import br.com.hexagonal.domain.shared.persistence.IPersistence;

public interface IProductPersistence extends IPersistence<String, IProduct> {
}
