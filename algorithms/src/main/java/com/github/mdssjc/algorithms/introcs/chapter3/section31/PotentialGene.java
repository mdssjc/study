package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.1.1 Identifying a potential gene.
 * <p>
 * Compilation:  javac PotentialGene.java
 * Execution:    java PotentialGene < input.txt
 * <p>
 * Determines whether a a DNA string corresponds to a potential gene
 * - length is a multiple of 3
 * - starts with the start codon (ATG)
 * - ends with a stop codon (TAA or TAG or TGA)
 * - has no intervening stop codons
 * <p>
 * % java PotentialGene ATGCGCCTGCGTCTGTACTAG
 * true
 * <p>
 * % java PotentialGene ATGCGCTGCGTCTGTACTAG
 * false
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("ATGCGCCTGCGTCTGTACTAG")
@TestDrive("ATGCGCTGCGTCTGTACTAG")
public class PotentialGene {

  public static boolean isPotentialGene(final String dna) {
    if (dna.length() % 3 != 0) {
      return false;
    }

    if (!dna.startsWith("ATG")) {
      return false;
    }

    for (var i = 3; i < dna.length() - 3; i++) {
      if (i % 3 == 0) {
        final var codon = dna.substring(i, i + 3);
        if (codon.equals("TAA")) {
          return false;
        }
        if (codon.equals("TAG")) {
          return false;
        }
        if (codon.equals("TGA")) {
          return false;
        }
      }
    }

    if (dna.endsWith("TAA")) {
      return true;
    }
    if (dna.endsWith("TAG")) {
      return true;
    }
    if (dna.endsWith("TGA")) {
      return true;
    }

    return false;
  }

  public static void main(final String[] args) {
    Executor.execute(PotentialGene.class, args);

    final var dna = args[0];
    StdOut.println(isPotentialGene(dna));
  }
}
