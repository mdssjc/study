package br.com.k19.testes;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.k19.modelo.Reserva;

public class AdicionaReserva {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(
                "K21_mapeamento_pu");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction()
               .begin();

        Reserva reserva = new Reserva();
        reserva.setInicio(LocalDate.of(2015, Month.AUGUST, 3));
        reserva.setTermino(LocalDate.of(2015, Month.AUGUST, 14));

        manager.persist(reserva);

        manager.getTransaction()
               .commit();

        manager.close();
        factory.close();
    }
}
