package br.com.k19.modelo;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Cacheable(true)
@Data
public class Cidade {

    @Id
    @GeneratedValue
    private Long   id;

    private String nomeDaCidade;

    private String nomeDoEstado;
}
