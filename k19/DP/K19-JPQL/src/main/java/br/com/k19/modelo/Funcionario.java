package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue
    private Long         id;

    private String       nome;

    @ManyToOne
    private Departamento departamento;
}
