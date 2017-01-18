package com.github.mdssjc.fj21_agenda.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LogicCommand {

  String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception;
}
