package br.com.k19.modelo;

import lombok.Data;

@Data
public class Ligacao {

  private Long    id;
  private Integer duracao;
  private Fatura  fatura;
}
