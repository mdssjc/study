package com.github.mdssjc.tarefas.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class User {
  @NotNull
  @Size(max = 255)
  String login;
  @NotNull
  @Size(max = 255)
  String password;

  public User() {
  }
}
