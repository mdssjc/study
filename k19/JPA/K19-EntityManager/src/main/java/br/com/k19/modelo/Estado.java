package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Estado {

    @Id
    @GeneratedValue
    private Long       id;

    private String     nome;

    @OneToOne(fetch = FetchType.LAZY)
    private Governador governador;
}
