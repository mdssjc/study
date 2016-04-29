package com.github.mdssjc.cdc.jpa.model;

import java.io.Serializable;

public class MusicaId implements Serializable {

  private static final long serialVersionUID = 1L;
  private int               codigoUnico;
  private int               autor;

  public MusicaId() {
  }

  public MusicaId(final int codigoUnico, final int autor) {
    this.codigoUnico = codigoUnico;
    this.autor = autor;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.autor;
    result = prime * result + this.codigoUnico;
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
    if (this.autor != other.autor) {
      return false;
    }
    if (this.codigoUnico != other.codigoUnico) {
      return false;
    }
    return true;
  }
}
