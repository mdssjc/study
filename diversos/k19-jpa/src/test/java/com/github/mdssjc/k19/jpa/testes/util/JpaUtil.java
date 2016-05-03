package com.github.mdssjc.k19.jpa.testes.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {

  private static final String               PERSISTENCE_UNIT    = "PU_K19_JPA";
  private static ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<>();
  private static EntityManagerFactory       entityManagerFactory;

  public JpaUtil() {
  }

  public static EntityManager getEntityManager() {
    if (JpaUtil.entityManagerFactory == null) {
      JpaUtil.entityManagerFactory = Persistence.createEntityManagerFactory(
          JpaUtil.PERSISTENCE_UNIT);
    }

    EntityManager entityManager = JpaUtil.threadEntityManager.get();

    if (entityManager == null || !entityManager.isOpen()) {
      entityManager = JpaUtil.entityManagerFactory.createEntityManager();
      JpaUtil.threadEntityManager.set(entityManager);
    }

    return entityManager;
  }

  public static void closeEntityManager() {
    final EntityManager em = JpaUtil.threadEntityManager.get();

    if (em != null) {
      final EntityTransaction transaction = em.getTransaction();

      if (transaction.isActive()) {
        transaction.commit();
      }

      em.close();

      JpaUtil.threadEntityManager.set(null);
    }
  }

  public static void closeEntityManagerFactory() {
    closeEntityManager();
    JpaUtil.entityManagerFactory.close();
  }
}
