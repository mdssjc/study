package com.github.mdssjc.cdc.jpa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CodigoUnico {

  @Id
  @GeneratedValue
  private int    id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date   dateRegistro;
  private String codigoUnicoHash;

  public int getId() {
    return this.id;
  }

  public Date getDateRegistro() {
    return this.dateRegistro;
  }

  public void setDateRegistro(final Date dateRegistro) {
    this.dateRegistro = dateRegistro;
  }

  public String getCodigoUnicoHash() {
    return this.codigoUnicoHash;
  }

  public void setCodigoUnicoHash(final String codigoUnicoHash) {
    this.codigoUnicoHash = codigoUnicoHash;
  }
}
