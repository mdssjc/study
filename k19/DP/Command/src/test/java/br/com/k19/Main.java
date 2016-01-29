package br.com.k19;

import br.com.k19.command.concrete.AumentaVolumeComando;
import br.com.k19.command.concrete.DiminuiVolumeComando;
import br.com.k19.command.concrete.TocaMusicaComando;
import br.com.k19.invoker.ListaDeComandos;
import br.com.k19.receiver.Player;

/**
 * Design Pattern
 * Behavioral - Command (Action, Transaction)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Player player = new Player();
    final ListaDeComandos listaDeComandos = new ListaDeComandos();

    listaDeComandos.adiciona(new TocaMusicaComando(player, "musica1.mp3"));
    listaDeComandos.adiciona(new AumentaVolumeComando(player, 3));
    listaDeComandos.adiciona(new TocaMusicaComando(player, "musica2.mp3"));
    listaDeComandos.adiciona(new DiminuiVolumeComando(player, 3));
    listaDeComandos.adiciona(new TocaMusicaComando(player, "musica3.mp3"));

    listaDeComandos.executa();
  }
}
