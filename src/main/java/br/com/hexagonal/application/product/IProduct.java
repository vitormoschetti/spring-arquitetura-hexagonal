package br.com.hexagonal.application.product;

import java.math.BigDecimal;

public interface IProduct {

    void enable();

    void disable();

    String getId();

    String getName();

    String getStatus();

    BigDecimal getPrice();

}
