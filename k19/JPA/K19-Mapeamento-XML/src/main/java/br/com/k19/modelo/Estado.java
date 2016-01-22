package br.com.k19.modelo;

import lombok.Data;

@Data
public class Estado {

  private Long       id;

  private String     nome;

  private Governador governador;
}
