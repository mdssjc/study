package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;

@Data
public class Livro {

  private Long              id;
  private String            nome;
  private Collection<Autor> autores = new ArrayList<>();
}
