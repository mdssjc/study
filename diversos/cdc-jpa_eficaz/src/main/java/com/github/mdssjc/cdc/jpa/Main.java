package com.github.mdssjc.cdc.jpa;

import javax.persistence.EntityManager;

import com.github.mdssjc.cdc.jpa.util.JpaUtil;

public class Main {

  public static void main(final String[] args) {
    final EntityManager entityManager = JpaUtil.getEntityManager();

    try {
      entityManager.getTransaction()
                   .begin();

      // ...

      entityManager.getTransaction()
                   .commit();
    } catch (final Exception e) {
      if (entityManager.isOpen()) {
        entityManager.getTransaction()
                     .rollback();
      }
    } finally {
      if (entityManager.isOpen()) {
        entityManager.close();
      }
    }
  }
}
