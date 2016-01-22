package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import lombok.Data;

@Data
public class Fatura {

  private Long                id;
  private Calendar            vencimento;
  private Collection<Ligacao> ligacoes = new ArrayList<>();
}
