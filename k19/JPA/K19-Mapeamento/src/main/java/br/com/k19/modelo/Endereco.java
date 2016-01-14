package br.com.k19.modelo;

import lombok.Data;

@Data
public class Endereco {

    private String estado;
    private String cidade;
    private String logradouro;
    private int    numero;
}
