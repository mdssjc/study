package br.com.k19.managebeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.sessionbeans.ChatBean;

@ManagedBean
public class ChatMB {

    @EJB
    private ChatBean chatBean;

    private String   sala;

    public void adicionaSala() {
        chatBean.criaSala(sala);
    }

    public List<String> getSalas() {
        return chatBean.listaSalas();
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
