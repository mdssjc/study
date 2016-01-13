package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Autor;

public class ListaAutoresComJPA {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_livraria_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Autor e");

        List<Autor> autores = query.getResultList();

        for (Autor a : autores) {
            System.out.println("AUTOR: " + a.getNome());
        }
    }
}
