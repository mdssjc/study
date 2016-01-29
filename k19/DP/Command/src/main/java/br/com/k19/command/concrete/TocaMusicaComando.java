package br.com.k19.command.concrete;

import br.com.k19.command.Comando;
import br.com.k19.receiver.Player;
import lombok.AllArgsConstructor;

/**
 * Concrete Command Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public class TocaMusicaComando implements Comando {

  private final Player player;
  private final String file;

  @Override
  public void executa() {
    try {
      this.player.play(this.file);
    } catch (final InterruptedException e) {
      e.printStackTrace();
    }
  }
}
