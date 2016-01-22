package br.com.k19.modelo;

import java.util.Calendar;

import lombok.Data;

@Data
public class Candidato {

  private Long     id;
  private String   nome;
  private Calendar nascimento;
  private Endereco endereco;
}
