package br.com.k19.multiton;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * Multiton Class
 *
 * @author mdssjc
 *
 */
public class Tema {

  @Getter
  @Setter
  private String                   nome;
  @Getter
  @Setter
  private Color                    corDoFundo;
  @Getter
  @Setter
  private Color                    corDaFonte;

  private static Map<String, Tema> temas = new HashMap<>();

  public static final String       SKY   = "Sky";
  public static final String       FIRE  = "Fire";

  static {
    final Tema tema1 = new Tema();
    tema1.setNome(Tema.SKY);
    tema1.setCorDoFundo(Color.BLUE);
    tema1.setCorDaFonte(Color.BLACK);

    final Tema tema2 = new Tema();
    tema2.setNome(Tema.FIRE);
    tema2.setCorDoFundo(Color.RED);
    tema2.setCorDaFonte(Color.WHITE);

    Tema.temas.put(tema1.getNome(), tema1);
    Tema.temas.put(tema2.getNome(), tema2);
  }

  private Tema() {
  }

  public static Tema getInstance(final String nomeDoTema) {
    return Tema.temas.get(nomeDoTema);
  }
}
