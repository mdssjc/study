package com.github.mdssjc.tarefas.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Calendar;

@Data
public class Task {
  private Long id;

  @NotNull
  @Size(min = 5)
  private String descricao;
  private boolean finalizado;
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Calendar dataFinalizacao;

  public Task() {
  }
}
