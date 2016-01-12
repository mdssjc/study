package br.com.k19.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

public class GeradorDeNumeros {

    @Named
    @Produces
    public List<Double> getNumeros() {
        ArrayList<Double> numeros = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            numeros.add(Math.random());
        }
        return numeros;
    }
}
