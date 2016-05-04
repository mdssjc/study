package com.github.mdssjc.k19.jpa.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

import lombok.Data;

@Data
@Entity
public class Produto {

  @Id
  @GeneratedValue
  private final Long id = 0L;
  private String     nome;
  private Double     preco;

  @PrePersist
  public void PrePersist() {
    System.out.println(
        "Persistindo um novo objeto com persist() ou merge()...");
  }

  @PostPersist
  public void postPersist() {
    System.out.println(
        "O comando insert foi executado no banco de dados...");
    System.out.println(
        "Um rollback ainda pode desfazer o comando insert...");
  }
}
