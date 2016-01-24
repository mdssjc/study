package br.com.k19.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

import lombok.Data;

@NamedStoredProcedureQuery(name = "BuscaProdutos", resultClasses = Produto.class, procedureName = "BUSCA_PRODUTOS", parameters = {
    @StoredProcedureParameter(mode = ParameterMode.IN, name = "PRECO_MINIMO", type = Double.class) })
@Entity
@Data
public class Produto {

  @Id
  @GeneratedValue
  private Long   id;

  private String nome;

  private Double preco;
}
