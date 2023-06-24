package br.com.hexagonal.domain.shared.entity;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class BaseEntity implements IEntity {

    protected Boolean isInvalid(final String attribute) {
        return Objects.isNull(attribute) || attribute.isBlank();
    }

    protected Boolean isInvalid(final BigDecimal attribute) {
        return Objects.isNull(attribute) || attribute.compareTo(BigDecimal.ZERO) < 0;
    }

    protected abstract void isValid();


}
