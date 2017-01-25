package com.github.mdssjc.tarefas.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
@Entity(name="tarefas")
public class Task {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull(message = "{task.description.empty}")
  @Size(min = 5, message = "{task.description.minimum}")
  private String descricao;
  private boolean finalizado;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  @Temporal(TemporalType.DATE)
  private Calendar dataFinalizacao;

  public Task() {
  }
}
