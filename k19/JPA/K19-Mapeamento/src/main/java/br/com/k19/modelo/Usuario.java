package br.com.k19.modelo;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue
    private Long     id;

    @Column(unique = true)
    private String   email;

    @Temporal(TemporalType.DATE)
    private Calendar dataDeCadastro;

    @Lob
    private byte[]   foto;
}
