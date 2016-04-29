package com.github.mdssjc.cdc.jpa.model;

import java.io.Serializable;

public class MusicaId implements Serializable {

  private static final long serialVersionUID = 1L;
  private int               duracaoSegundos;
  private String            nome;

  public MusicaId() {
  }

  public MusicaId(final int duracaoSegundos, final String nome) {
    this.duracaoSegundos = duracaoSegundos;
    this.nome = nome;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.duracaoSegundos;
    result = prime * result + ((this.nome == null) ? 0 : this.nome.hashCode());
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
    final MusicaId other = (MusicaId) obj;
    if (this.duracaoSegundos != other.duracaoSegundos) {
      return false;
    }
    if (this.nome == null) {
      if (other.nome != null) {
        return false;
      }
    } else if (!this.nome.equals(other.nome)) {
      return false;
    }
    return true;
  }
}
