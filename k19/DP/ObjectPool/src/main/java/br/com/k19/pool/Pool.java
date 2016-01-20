package br.com.k19.pool;

/**
 * Pool Interface
 *
 * @author mdssjc
 * @param <T>
 *
 */
public interface Pool<T> {

  T acquire();

  void release(T t);
}
