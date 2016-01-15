package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Governador {

    @Id
    @GeneratedValue
    private Long   id;

    private String nome;

    @OneToOne(mappedBy = "governador")
    private Estado estado;
}
