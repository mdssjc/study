package com.github.mdssjc.cdc.tas;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lance {

  @Id
  @GeneratedValue
  private int      id;
  private double   valor;
  private Calendar data;
  @ManyToOne
  private Usuario  usuario;
  @ManyToOne
  private Leilao   leilao;

  protected Lance() {
  }

  public Lance(final Calendar data, final Usuario usuario, final double valor,
      final Leilao leilao) {
    this.usuario = usuario;
    this.data = data;
    this.valor = valor;
    this.leilao = leilao;
  }

  public Lance(final Usuario usuario, final double valor) {
    this.usuario = usuario;
    this.valor = valor;
  }

  public double getValor() {
    return this.valor;
  }

  public void setValor(final double valor) {
    this.valor = valor;
  }

  public Leilao getLeilao() {
    return this.leilao;
  }

  public void setLeilao(final Leilao leilao) {
    this.leilao = leilao;
  }

  public Calendar getData() {
    return this.data;
  }

  public void setData(final Calendar data) {
    this.data = data;
  }

  public Usuario getUsuario() {
    return this.usuario;
  }

  public void setUsuario(final Usuario usuario) {
    this.usuario = usuario;
  }

  public int getId() {
    return this.id;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((this.usuario == null) ? 0 : this.usuario.hashCode());
    long temp;
    temp = Double.doubleToLongBits(this.valor);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Lance other = (Lance) obj;
    if (this.usuario == null) {
      if (other.usuario != null) {
        return false;
      }
    } else if (!this.usuario.equals(other.usuario)) {
      return false;
    }
    if (Double.doubleToLongBits(this.valor) != Double.doubleToLongBits(
        other.valor)) {
      return false;
    }
    return true;
  }
}
