package app.models;

import javax.xml.bind.annotation.XmlRootElement;

@javax.persistence.Entity
@XmlRootElement
public class Usuario extends Entity {

  private String nome;
  private String email;

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
