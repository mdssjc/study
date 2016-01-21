package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

import lombok.Data;

@Entity
@Audited
@Data
public class Pessoa {

  @Id
  @GeneratedValue
  private Long   id;

  private String nome;
}
