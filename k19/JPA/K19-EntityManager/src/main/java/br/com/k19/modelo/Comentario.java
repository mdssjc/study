package br.com.k19.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue
    private Long     id;

    @Temporal(TemporalType.DATE)
    private Calendar data;
}
