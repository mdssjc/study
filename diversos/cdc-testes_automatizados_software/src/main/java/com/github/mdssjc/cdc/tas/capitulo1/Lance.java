package com.github.mdssjc.cdc.tas.capitulo1;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Lance implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Usuario           usuario;
  private double            valor;

  public Lance() {
  }

  public Lance(final Usuario usuario, final double valor) {
    this.usuario = usuario;
    this.valor = valor;
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

  public Usuario getUsuario() {
    return this.usuario;
  }

  public double getValor() {
    return this.valor;
  }
}
