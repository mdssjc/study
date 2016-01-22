package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.Collection;

import lombok.Data;

@Data
public class Departamento {

  private Long                    id;

  private String                  nome;

  private Collection<Funcionario> funcionarios = new ArrayList<>();
}
