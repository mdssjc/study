package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import lombok.Data;

@Entity
@Indexed
@Data
public class Pessoa {

  @Id
  @GeneratedValue
  private Long   id;

  @Field
  private String nome;
}
