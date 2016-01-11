package br.com.k19.managebeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.entidades.Mensagem;
import br.com.k19.sessionbeans.MensagemRepositorio;

@ManagedBean
public class MensagemMB {

    @EJB
    private MensagemRepositorio repositorio;

    private Mensagem            mensagem = new Mensagem();

    private List<Mensagem>      mensagensCache;

    public void adiciona() {
        repositorio.adiciona(mensagem);
        mensagem = new Mensagem();
        mensagensCache = null;
    }

    public List<Mensagem> getMensagens() {
        if (mensagensCache == null) {
            mensagensCache = repositorio.getMensagens();
        }
        return mensagensCache;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }
}
