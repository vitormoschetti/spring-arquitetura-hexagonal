package br.com.hexagonal.domain.shared.persistence;

public interface IReader<TParam, TOut> {

    TOut get(final TParam param);

}
