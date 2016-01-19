package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Autor {

  @Id
  @GeneratedValue
  private Long              id;

  private String            nome;

  @ManyToMany
  private Collection<Livro> livros = new ArrayList<>();
}
