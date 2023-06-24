package br.com.hexagonal.domain.product.entity;

import br.com.hexagonal.domain.product.enums.ProductStatus;
import br.com.hexagonal.domain.shared.entity.BaseEntity;
import br.com.hexagonal.domain.shared.exception.DomainException;

import java.math.BigDecimal;
import java.util.UUID;

public class Product extends BaseEntity implements IProduct {

    private final String id;
    private final String name;
    private BigDecimal price;
    private ProductStatus status;

    public Product(final String name, final BigDecimal price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.isValid();
    }

    @Override
    protected void isValid() {
        if (this.isInvalid(this.name))
            throw new DomainException("Name is required");
        if (this.isInvalid(this.price))
            throw new DomainException("Price must be greater or equal than zero");
    }


    @Override
    public void enable() {
        if (this.price.compareTo(BigDecimal.ZERO) > 0)
            this.status = ProductStatus.ENABLE;
        else
            throw new DomainException("The price must be greater than zero to enable the product");
    }

    @Override
    public void disable() {
        if (this.price.compareTo(BigDecimal.ZERO) == 0)
            this.status = ProductStatus.DISABLE;
        else
            throw new DomainException("The price must be zero to disable the product");
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getStatus() {
        return this.status.name();
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void changePrice(final BigDecimal price) {
        if (this.isInvalid(price))
            throw new DomainException("Price must be greater or equal than zero");
        this.price = price;
    }
}
