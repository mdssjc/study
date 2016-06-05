/*
 * Design Pattern
 * Behavioral - Strategy
 * 
 */

package base;

import algorithms.AlgorithmA;
import algorithms.AlgorithmB;
import algorithms.AlgorithmC;
import contexts.ImpA;
import contexts.ImpB;
import contexts.ImpC;
import contexts.ImpNull;
import contexts.ImpX;

public class Main {

    public static void main(String[] args) {
        ImpX ca = new ImpA();
        ImpX cb = new ImpB();
        ImpX cc = new ImpC();

        System.out.println("<<Execution>>");
        ca.useAlgorithm();
        cb.useAlgorithm();
        cc.useAlgorithm();

        System.out.println("<<Change>>");
        ca.setAlg(new AlgorithmB());
        ca.useAlgorithm();
        ca.setAlg(new AlgorithmC());
        ca.useAlgorithm();
        ca.setAlg(new AlgorithmA());
        ca.useAlgorithm();

        System.out.println("<<Null>>");
        ImpX cnull = new ImpNull();
        cnull.useAlgorithm();
    }
}
