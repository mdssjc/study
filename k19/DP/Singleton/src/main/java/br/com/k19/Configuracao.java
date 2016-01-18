package br.com.k19;

import java.util.HashMap;
import java.util.Map;

/**
 * Singleton Class
 *
 * @author mdssjc
 *
 */
public class Configuracao {

  private final Map<String, String> propriedades;
  private static Configuracao       instance;

  private Configuracao() {
    this.propriedades = new HashMap<>();
    this.propriedades.put("time-zone", "America/Sao_Paulo");
    this.propriedades.put("currency-code", "BRL");
  }

  public static Configuracao getInstance() {
    if (Configuracao.instance == null) {
      Configuracao.instance = new Configuracao();
    }
    return Configuracao.instance;
  }

  public String getPropriedade(final String nomeDaPropriedade) {
    return this.propriedades.get(nomeDaPropriedade);
  }
}
