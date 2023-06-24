package br.com.hexagonal.domain.shared.persistence;

public interface IWriter<T> {

    T save(final T param);

}
