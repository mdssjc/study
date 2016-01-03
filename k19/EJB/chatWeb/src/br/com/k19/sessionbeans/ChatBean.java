package br.com.k19.sessionbeans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Singleton;

@Singleton
public class ChatBean {

    private Set<String> salas = new HashSet<>();

    public void criaSala(String sala) {
        salas.add(sala);
    }

    public List<String> listaSalas() {
        return new ArrayList<String>(salas);
    }
}
