package mds.java.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import mds.java.entity.Task;
import mds.java.persistence.DAOException;
import mds.java.persistence.TaskDAO;

@Controller
public class TaskController {

    @RequestMapping("newForm")
    public String form() {
	return "task/form";
    }

    @RequestMapping("newTask")
    public String add(@Valid Task task, BindingResult result) {
	if (result.hasFieldErrors("descricao")) {
	    return "task/form";
	}

	try {
	    TaskDAO dao = new TaskDAO();
	    dao.save(task);
	} catch (DAOException e) {
	    e.printStackTrace();
	}
	return "task/added";
    }
}
