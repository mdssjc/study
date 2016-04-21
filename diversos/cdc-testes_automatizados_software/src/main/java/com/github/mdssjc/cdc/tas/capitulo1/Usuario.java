package com.github.mdssjc.cdc.tas.capitulo1;

public class Usuario {

  private final String nome;

  public Usuario(final String nome) {
    this.nome = nome;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.getNome() == null) ? 0 : this.getNome()
                                                                  .hashCode());
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
    final Usuario other = (Usuario) obj;
    if (this.getNome() == null) {
      if (other.getNome() != null) {
        return false;
      }
    } else if (!this.getNome()
                    .equals(other.getNome())) {
      return false;
    }
    return true;
  }

  public String getNome() {
    return this.nome;
  }
}
