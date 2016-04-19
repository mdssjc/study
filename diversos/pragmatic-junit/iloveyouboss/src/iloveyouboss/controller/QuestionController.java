
package iloveyouboss.controller;

import java.time.Clock;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import iloveyouboss.domain.BooleanQuestion;
import iloveyouboss.domain.PercentileQuestion;
import iloveyouboss.domain.Persistable;
import iloveyouboss.domain.Question;

public class QuestionController {

  private Clock clock = Clock.systemUTC();

  private static EntityManagerFactory getEntityManagerFactory() {
    return Persistence.createEntityManagerFactory("mysql-ds");
  }

  public Question find(final Integer id) {
    return em().find(Question.class, id);
  }

  public List<Question> getAll() {
    return em().createQuery("select q from Question q", Question.class)
               .getResultList();
  }

  public List<Question> findWithMatchingText(final String text) {
    return em()
               .createQuery(
                   "select q from Question q where q.text like '%" + text
                       + "%'",
                   Question.class)
               .getResultList();
  }

  public int addPercentileQuestion(final String text,
      final String[] answerChoices) {
    return persist(new PercentileQuestion(text, answerChoices));
  }

  public int addBooleanQuestion(final String text) {
    return persist(new BooleanQuestion(text));
  }

  void setClock(final Clock clock) {
    this.clock = clock;
  }

  void deleteAll() {
    executeInTransaction(
        (em) -> em.createNativeQuery("delete from AnswerChoice")
                  .executeUpdate());
    executeInTransaction(
        (em) -> em.createNativeQuery("delete from Question")
                  .executeUpdate());
  }

  private void executeInTransaction(final Consumer<EntityManager> func) {
    final EntityManager em = em();

    final EntityTransaction transaction = em.getTransaction();
    try {
      transaction.begin();
      func.accept(em);
      transaction.commit();
    } catch (final Throwable t) {
      t.printStackTrace();
      transaction.rollback();
    } finally {
      em.close();
    }
  }

  private int persist(final Persistable object) {
    object.setCreateTimestamp(this.clock.instant());
    executeInTransaction((em) -> em.persist(object));
    return object.getId();
  }

  private EntityManager em() {
    return getEntityManagerFactory().createEntityManager();
  }
}
