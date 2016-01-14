package br.com.k19.modelo;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class PessoaFisica extends Pessoa {

    private String cpf;
}
