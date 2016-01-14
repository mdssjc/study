package br.com.k19.modelo;

import java.util.Calendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Candidato {

    @Id
    @GeneratedValue
    private Long     id;

    private String   nome;

    @Temporal(TemporalType.DATE)
    private Calendar nascimento;

    @Embedded
    private Endereco endereco;
}
