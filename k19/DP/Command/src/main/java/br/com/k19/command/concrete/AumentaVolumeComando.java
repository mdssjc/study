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
public class AumentaVolumeComando implements Comando {

  private final Player player;
  private final int    levels;

  @Override
  public void executa() {
    this.player.increaseVolume(this.levels);
  }
}
