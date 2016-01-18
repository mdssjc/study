package br.com.k19.tests;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import br.com.k19.prototype.concrete.Campanha;

/**
 * Design Pattern
 * Creational - Prototype
 *
 * @author mdssjc
 *
 */
public class Main {

  public static void main(final String[] args) {
    final String nome = "K19";

    final Calendar vencimento = Calendar.getInstance();
    vencimento.add(Calendar.DATE, 30);

    final Set<String> hashSet = new HashSet<String>();

    hashSet.add("curso");
    hashSet.add("java");
    hashSet.add("k19");

    final Campanha campanha = new Campanha(nome, vencimento, hashSet);
    System.out.println(campanha);

    final Campanha clone = campanha.getClone();
    System.out.println(clone);
  }
}
