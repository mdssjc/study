package br.com.k19.artifact;

import java.util.ArrayList;
import java.util.List;

/**
 * Artifact Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Apresentacao {

  private final List<Slide> slides = new ArrayList<>();

  public void adicionaSlide(final Slide slide) {
    this.slides.add(slide);
  }

  public void imprime() {
    for (final Slide slide : this.slides) {
      slide.imprime();
      System.out.println();
    }
  }
}
