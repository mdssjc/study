package br.com.k19.invoker;

import java.util.ArrayList;
import java.util.List;

import br.com.k19.command.Comando;

/**
 * Invoker Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class ListaDeComandos {

  private final List<Comando> comandos = new ArrayList<>();

  public void adiciona(final Comando comando) {
    this.comandos.add(comando);
  }

  public void executa() {
    for (final Comando comando : this.comandos) {
      comando.executa();
    }
  }
}
