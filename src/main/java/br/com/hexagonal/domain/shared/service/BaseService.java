package br.com.hexagonal.domain.shared.service;

import br.com.hexagonal.domain.shared.persistence.IPersistence;

public abstract class BaseService<T extends IPersistence> implements IService {

    protected final T persistence;

    protected BaseService(final T persistence) {
        this.persistence = persistence;
    }
}
