package br.com.k19.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.k19.modelo.Editora;

public class ListaEditorasComJPA {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_livraria_pu");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("SELECT e FROM Editora e");
        List<Editora> editoras = query.getResultList();
        for (Editora e : editoras) {
            System.out.println(
                    "EDITORA: " + e.getNome() + " - " + e.getEmail());
        }

        manager.close();
        factory.close();
    }
}
