package mds.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mds.java.entity.Task;
import mds.java.persistence.DAOException;
import mds.java.persistence.TaskDAO;

@Controller
public class TaskController {

    private final TaskDAO dao;

    @Autowired
    public TaskController(TaskDAO dao) {
	this.dao = dao;
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
    public String add(@Valid Task task, BindingResult result) {
	try {
	    if (result.hasFieldErrors("descricao")) {
		return "task/form";
	    }
	    dao.save(task);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	return "task/added";
    }

    @RequestMapping("listAll")
    public String list(Model model) {
	try {
	    model.addAttribute("tarefas", dao.findAll());
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	return "task/list";
    }

    @RequestMapping("showTask")
    public String show(Long id, Model model) {
	try {
	    model.addAttribute("tarefa", dao.findById(id));
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	return "task/update";
    }

    @RequestMapping("updateTask")
    public String update(Task task) {
	try {
	    dao.set(task);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	return "redirect:listAll";

    }

    @RequestMapping("removeTask")
    public String del(Task task) {
	try {
	    dao.delete(task);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	return "redirect:listAll";
    }

    @RequestMapping("closeTask")
    public String close(Long id, Model model) {
	try {
	    dao.closeTask(id);
	    model.addAttribute("tarefa", dao.findById(id));
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	return "task/closed";
    }
}
