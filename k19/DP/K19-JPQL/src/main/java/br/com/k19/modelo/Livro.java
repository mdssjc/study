package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.Data;

@Entity
@NamedQuery(name = "Livro.findByPrecoMinimo", query = "SELECT l FROM Livro l WHERE l.preco >= :preco")
@Data
public class Livro {

    @Id
    @GeneratedValue
    private Long   id;

    private String nome;

    private Double preco;
}
