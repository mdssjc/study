package br.com.k19.testes;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Autor;

public class InsereAtoresComJPA {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_livraria_pu");
        EntityManager manager = factory.createEntityManager();

        Autor autor = new Autor();

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o nome do autor: ");
        autor.setNome(entrada.nextLine());

        entrada.close();

        manager.persist(autor);

        manager.getTransaction()
               .begin();
        manager.getTransaction()
               .commit();

        factory.close();
    }
}
