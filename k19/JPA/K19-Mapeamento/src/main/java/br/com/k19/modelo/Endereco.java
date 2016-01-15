package br.com.k19.modelo;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Endereco {

    private String estado;
    private String cidade;
    private String logradouro;
    private int    numero;
}
