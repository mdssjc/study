package com.github.mdssjc.cdc.tas.capitulo1;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long              id;
  private String            nome;
  private String            email;

  public Usuario() {
  }

  public Usuario(final String nome) {
    this.nome = nome;
  }

  public Usuario(final String nome, final String email) {
    this(nome);
    this.email = email;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((this.email == null) ? 0 : this.email.hashCode());
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
    final Usuario other = (Usuario) obj;
    if (this.email == null) {
      if (other.email != null) {
        return false;
      }
    } else if (!this.email.equals(other.email)) {
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

  public Long getId() {
    return this.id;
  }

  public String getNome() {
    return this.nome;
  }

  public String getEmail() {
    return this.email;
  }
}
