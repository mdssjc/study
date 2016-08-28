package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

import edu.princeton.cs.algs4.StdOut;

/**
 * Exercício 6.
 * 
 * @author Marcelo dos Santos
 *
 */
@TestDrive({ "TGA", "GAT" })
@TestDrive({ "TGA", "GATC" })
@TestDrive({ "TGA", "GTA" })
@TestDrive({ "ACTGACG", "TGACGAC" })
public class Ex6 {

  public static void main(final String[] args) {
    Executor.execute(Ex6.class, args);

    final String s = args[0];
    final String t = args[1];

    if (s.length() != t.length()) {
      StdOut.println("NC");
    } else {
      int index = t.indexOf(s.substring(0, 1));
      while (index != -1) {
        final String string = t.substring(index) + t.substring(0, index);
        if (s.equals(string)) {
          StdOut.println("Detected - Circular Shift");
          break;
        }
        index = t.indexOf(s.substring(0, 1), index + 1);
      }
    }
  }
}
