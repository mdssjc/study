package br.com.k19.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Topico {

    @Id
    @GeneratedValue
    private Long             id;

    @OneToMany(cascade = { CascadeType.PERSIST }, orphanRemoval = true)
    private List<Comentario> comentarios = new ArrayList<>();

    private String           titulo;
}
