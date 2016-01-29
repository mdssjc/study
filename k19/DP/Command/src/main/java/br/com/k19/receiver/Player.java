package br.com.k19.receiver;

/**
 * Receiver Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Player {

  public void play(final String filename) throws InterruptedException {
    System.out.println("Tocando o arquivo " + filename);
    final long duracao = (long) (Math.random() * 2000);
    System.out.println("Duração (s) : " + duracao / 1000.0);
    Thread.sleep(duracao);
    System.out.println("Fim");
  }

  public void increaseVolume(final int levels) {
    System.out.println("Aumentando o volume em " + levels);
  }

  public void decreaseVolume(final int levels) {
    System.out.println("Diminuindo o volume em " + levels);
  }
}
