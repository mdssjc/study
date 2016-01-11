package br.com.k19.sessionbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Singleton;

@Singleton
public class TarefasBean {

    private List<String> tarefas = new ArrayList<>();

    @RolesAllowed({ "admin", "users" })
    public void adiciona(String tarefa) {
        tarefas.add(tarefa);
    }

    @RolesAllowed({ "admin", "users" })
    public List<String> listaTarefas() {
        return tarefas;
    }

    @RolesAllowed({ "admin" })
    public void remove(String tarefa) {
        tarefas.remove(tarefa);
    }
}
