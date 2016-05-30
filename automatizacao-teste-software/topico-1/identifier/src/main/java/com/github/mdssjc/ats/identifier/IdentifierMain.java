package com.github.mdssjc.ats.identifier;

public class IdentifierMain {

  public static void main(final String[] args) {
    if (args.length == 0) {
      System.out.println("Uso: IdentifierMain <string>");
    } else {
      final Identifier id = new Identifier();
      if (id.validateIdentifier(args[0])) {
        System.out.println("Valido");
      } else {
        System.out.println("Invalido");
      }
    }
  }
}
