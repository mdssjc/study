package com.github.mdssjc.k19.jpa.testes.util;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class JpaEntityManager {

  protected static EntityManager manager;

  @BeforeClass
  public static void liga() {
    JpaEntityManager.manager = JpaUtil.getEntityManager();
  }

  @AfterClass
  public static void desliga() {
    JpaUtil.closeEntityManagerFactory();
  }

  @Before
  public void inicializa() {
    JpaEntityManager.manager.getTransaction()
                            .begin();
  }

  @After
  public void encerra() {
    JpaEntityManager.manager.getTransaction()
                            .rollback();
  }

  public void begin() {
    JpaEntityManager.manager.getTransaction()
                            .begin();
  }

  public void commit() {
    JpaEntityManager.manager.getTransaction()
                            .commit();
  }
}
