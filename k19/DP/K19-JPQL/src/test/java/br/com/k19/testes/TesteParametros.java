package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Livro;

public class TesteParametros {

    public static void main(final String[] args) {
        final EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_jpql_pu");
        final EntityManager manager = factory.createEntityManager();

        final Query query = manager.createNamedQuery("Livro.findByPrecoMinimo");
        query.setParameter("preco", 20.0);
        final List<Livro> livros = query.getResultList();

        for (final Livro livro : livros) {
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Preço: " + livro.getPreco());
        }

        manager.close();
        factory.close();
    }
}
