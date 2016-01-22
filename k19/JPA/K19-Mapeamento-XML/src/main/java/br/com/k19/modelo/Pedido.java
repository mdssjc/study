package br.com.k19.modelo;

import java.util.Calendar;

import lombok.Data;

@Data
public class Pedido {

  private Long     id;
  private Calendar data;
  private Cliente  cliente;
}
