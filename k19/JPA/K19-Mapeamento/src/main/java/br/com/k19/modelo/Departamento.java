package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Departamento {

    @Id
    @GeneratedValue
    private Long                    id;

    private String                  nome;

    @OneToMany
    private Collection<Funcionario> funcionarios = new ArrayList<>();
}
