package br.com.k19.tests;

import br.com.k19.multiton.Tema;

/**
 * Design Pattern
 * Creational - Multiton (non GoF)
 *
 * @author mdssjc
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Tema temaFire = Tema.getInstance(Tema.FIRE);
    Main.print(temaFire);

    final Tema temaFire2 = Tema.getInstance(Tema.FIRE);
    Main.print(temaFire2);

    System.out.println("--------");
    System.out.println("Comparando as referências...");
    System.out.println(temaFire == temaFire2);
  }

  public static void print(final Tema temaFire) {
    System.out.println("Tema " + temaFire.getNome());
    System.out.println("Cor da Fonte : " + temaFire.getCorDaFonte());
    System.out.println("Cor do Fundo : " + temaFire.getCorDoFundo());
  }
}
