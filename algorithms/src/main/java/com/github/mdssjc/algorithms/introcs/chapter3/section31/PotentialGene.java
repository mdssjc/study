package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.1.1 Identifying a potential gene.
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

    for (int i = 3; i < dna.length() - 3; i++) {
      if (i % 3 == 0) {
        final String codon = dna.substring(i, i + 3);
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

    final String dna = args[0];
    final boolean result = isPotentialGene(dna);

    StdOut.println(result);
  }
}
