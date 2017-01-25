package com.github.mdssjc.tarefas.controller;

import com.github.mdssjc.tarefas.entity.Task;
import com.github.mdssjc.tarefas.persistence.ITaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Transactional
public class TaskController {

  @Autowired
  private ITaskDAO dao;

  public TaskController() {
  }

  @RequestMapping("")
  public String index() {
    return "redirect:listAll";
  }

  @RequestMapping("newForm")
  public String form() {
    return "task/form";
  }

  @RequestMapping("newTask")
  public String add(@Valid final Task task, final BindingResult result) {
    if (result.hasFieldErrors("description")) {
      return "task/form";
    }
    this.dao.save(task);
    return "task/added";
  }

  @RequestMapping("listAll")
  public String list(final Model model) {
    model.addAttribute("tasks", this.dao.findAll());
    return "task/list";
  }

  @RequestMapping("showTask")
  public String show(final Long id, final Model model) {
    model.addAttribute("tarefa", this.dao.findById(id));
    return "task/update";
  }

  @RequestMapping("updateTask")
  public String update(final Task task) {
    this.dao.set(task);
    return "redirect:listAll";
  }

  @RequestMapping("removeTask")
  public String remove(final Task task) {
    this.dao.delete(task);
    return "redirect:listAll";
  }

  @RequestMapping("closeTask")
  public String close(final Long id, final Model model) {
    this.dao.closeTask(id);
    model.addAttribute("tarefa", this.dao.findById(id));
    return "task/closed";
  }
}
