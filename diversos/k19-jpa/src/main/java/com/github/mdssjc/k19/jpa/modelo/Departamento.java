package com.github.mdssjc.k19.jpa.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Departamento {

  @Id
  @GeneratedValue
  private final Long              id           = 0L;
  private String                  nome;
  @OneToMany
  private Collection<Funcionario> funcionarios = new ArrayList<>();
}
