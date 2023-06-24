package br.com.hexagonal.domain.shared.persistence;

public interface IPersistence<TParam, TOut> extends IReader<TParam, TOut>, IWriter<TOut> {
}
