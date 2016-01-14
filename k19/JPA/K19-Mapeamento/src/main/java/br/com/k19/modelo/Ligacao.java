package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Ligacao {

    @Id
    @GeneratedValue
    private Long    id;

    @ManyToOne
    private Fatura  fatura;

    private Integer duracao;
}
