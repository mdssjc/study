package br.com.k19.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue
    private Long     id;

    @Temporal(TemporalType.DATE)
    private Calendar data;

    @ManyToOne
    private Cliente  cliente;
}
