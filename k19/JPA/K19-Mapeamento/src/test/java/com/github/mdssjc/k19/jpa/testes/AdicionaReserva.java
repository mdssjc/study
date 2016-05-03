package com.github.mdssjc.k19.jpa.testes;

import java.time.LocalDate;
import java.time.Month;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Reserva;

public class AdicionaReserva {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Reserva reserva = new Reserva();
    reserva.setInicio(LocalDate.of(2015, Month.AUGUST, 3));
    reserva.setTermino(LocalDate.of(2015, Month.AUGUST, 14));

    manager.persist(reserva);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}
