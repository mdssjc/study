package com.github.mdssjc.k19.jpa.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Topico {

  @Id
  @GeneratedValue
  private final Long       id          = 0L;
  @OneToMany(cascade = { CascadeType.PERSIST }, orphanRemoval = true)
  private List<Comentario> comentarios = new ArrayList<>();
  private String           titulo;
}
