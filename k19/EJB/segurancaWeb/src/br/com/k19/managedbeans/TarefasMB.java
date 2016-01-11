package br.com.k19.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.sessionbeans.TarefasBean;

@ManagedBean
public class TarefasMB {

    @EJB
    private TarefasBean tarefasBean;

    private String      tarefa;

    public void adiciona() {
        tarefasBean.adiciona(tarefa);
    }

    public void remove(String tarefa) {
        tarefasBean.remove(tarefa);
    }

    public List<String> getTarefas() {
        return tarefasBean.listaTarefas();
    }

    public String getTarefa() {
        return tarefa;
    }

    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }
}
