package br.com.k19.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Comentario;
import br.com.k19.modelo.Topico;

public class AdicionaTopicoComentarios {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_entity_manager_pu");
        EntityManager manager = factory.createEntityManager();

        Topico topico = new Topico();
        topico.setTitulo("K19 - Orphan Removal");

        for (int i = 0; i < 10; i++) {
            Comentario comentario = new Comentario();
            comentario.setData(Calendar.getInstance());
            topico.getComentarios()
                  .add(comentario);
        }

        manager.getTransaction()
               .begin();
        manager.persist(topico);
        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
