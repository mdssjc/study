package br.com.k19.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.entidades.Mensagem;
import br.com.k19.interceptadores.CensuraInteceptor;

@Stateless
public class MensagemRepositorio {

    @PersistenceContext
    private EntityManager manager;

    @Interceptors({ CensuraInteceptor.class })
    public void adiciona(Mensagem mensagem) {
        manager.persist(mensagem);
    }

    public List<Mensagem> getMensagens() {
        TypedQuery<Mensagem> query = manager.createQuery(
                "SELECT x FROM Mensagem x", Mensagem.class);
        return query.getResultList();
    }
}
