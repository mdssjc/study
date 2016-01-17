package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Livro {

    @Id
    @GeneratedValue
    private Long   id;

    private String nome;

    private Double preco;
}
