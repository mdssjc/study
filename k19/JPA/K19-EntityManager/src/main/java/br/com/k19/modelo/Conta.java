package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

@Entity
@Data
public class Conta {

    @Id
    @GeneratedValue
    private Long   id;

    private double saldo;

    @Version
    private Long   versao;
}
