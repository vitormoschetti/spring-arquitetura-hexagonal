package br.com.hexagonal.application.product;

import br.com.hexagonal.application.shared.DomainException;

import java.math.BigDecimal;

public class Product implements IProduct {

    private final String id;
    private final String name;
    private final BigDecimal price;
    private ProductStatus status;

    public Product(final String id, final String name, final BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isValid();
    }

    private Boolean isValid() {
        return null;
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
}
