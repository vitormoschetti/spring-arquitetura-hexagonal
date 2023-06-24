package br.com.hexagonal.domain.product.entity;

import br.com.hexagonal.domain.shared.entity.IEntity;

import java.math.BigDecimal;

public interface IProduct extends IEntity {

    void enable();

    void disable();

    String getId();

    String getName();

    String getStatus();

    BigDecimal getPrice();

    void changePrice(BigDecimal price);


}
