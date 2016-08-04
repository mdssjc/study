package com.algaworks.festa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.algaworks.festa.model.Convidado;

@Repository
public class Convidados {

  private static final List<Convidado> LISTA_CONVIDADOS = new ArrayList<>();

  static {
    Convidados.LISTA_CONVIDADOS.add(new Convidado("Pedro", 2));
    Convidados.LISTA_CONVIDADOS.add(new Convidado("Maria", 3));
    Convidados.LISTA_CONVIDADOS.add(new Convidado("Ricardo", 1));
  }

  public List<Convidado> todos() {
    return Convidados.LISTA_CONVIDADOS;
  }

  public void adicionar(final Convidado convidado) {
    Convidados.LISTA_CONVIDADOS.add(convidado);
  }
}
