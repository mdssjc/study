package br.com.k19.modelo;

import java.util.Calendar;

import lombok.Data;

@Data
public class Usuario {

  private Long     id;

  private String   email;

  private Calendar dataDeCadastro;

  private byte[]   foto;
}
