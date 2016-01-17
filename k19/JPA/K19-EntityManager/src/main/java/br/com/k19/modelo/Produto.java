package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue
    private Long   id;

    private String nome;

    private Double preco;

    @PrePersist
    public void PrePersist() {
        System.out.println(
                "Persistindo um novo objeto com persist() ou merge()...");
    }

    public void postPersist() {
        System.out.println(
                "O comando insert foi executado no banco de dados...");
        System.out.println(
                "Um rollback ainda pode desfazer o comando insert...");
    }
}
