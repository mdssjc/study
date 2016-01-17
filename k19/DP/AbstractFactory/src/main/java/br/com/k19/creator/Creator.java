package br.com.k19.creator;

/**
 * Creator Interface
 *
 * @author mdssjc
 *
 * @param <T> Emissor or Receptor
 */
public interface Creator<T> {

    int VISA       = 0;
    int MASTERCARD = 1;

    T create(int tipoDoEmissor);
}
