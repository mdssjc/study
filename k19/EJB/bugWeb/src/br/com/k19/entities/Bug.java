package br.com.k19.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Bug {

    @Id
    @GeneratedValue
    private Long    id;

    private String  description;

    private String  severity;

    @ManyToOne
    private Project project;
}
