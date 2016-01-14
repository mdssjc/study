package br.com.k19.modelo;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class PessoaJuridica extends Pessoa {

    private String cnpj;
}
