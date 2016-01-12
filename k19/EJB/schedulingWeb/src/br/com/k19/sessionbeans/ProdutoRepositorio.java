package br.com.k19.sessionbeans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.k19.entidades.Produto;

@Stateless
public class ProdutoRepositorio {

    @PersistenceContext
    private EntityManager manager;

    public void adiciona(Produto produto) {
        manager.persist(produto);
    }

    public List<Produto> getProdutos() {
        TypedQuery<Produto> query = manager.createQuery(
                "SELECT x FROM Produto x", Produto.class);
        return query.getResultList();
    }
}
