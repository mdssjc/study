package com.github.mdssjc.k19.jpa.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Fatura {

  @Id
  @GeneratedValue
  private final Long          id       = 0L;
  @OneToMany(mappedBy = "fatura")
  private Collection<Ligacao> ligacoes = new ArrayList<>();
  @Temporal(TemporalType.DATE)
  private Calendar            vencimento;
}
