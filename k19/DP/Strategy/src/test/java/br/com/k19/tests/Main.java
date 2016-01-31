package br.com.k19.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.k19.context.Context;
import br.com.k19.strategy.concrete.InsertionSorter;
import br.com.k19.strategy.concrete.SelectionSorter;

/**
 * Design Pattern
 * Behavioral - Strategy
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final List<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(3);
    list.add(2);
    list.add(14);

    final Context context = new Context();
    System.out.println(context);

    context.setSorter(new InsertionSorter());
    System.out.println(context);
    final List<Integer> list2 = context.run(list);
    for (final Integer integer : list2) {
      System.out.println(integer);
    }

    System.out.println();

    context.setSorter(new SelectionSorter());
    System.out.println(context);
    final List<Integer> list3 = context.run(list);
    for (final Integer integer : list3) {
      System.out.println(integer);
    }
  }
}
