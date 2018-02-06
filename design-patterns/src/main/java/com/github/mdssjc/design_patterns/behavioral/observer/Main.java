package com.github.mdssjc.design_patterns.behavioral.observer;

/**
 * Padrão de projeto: Observer.
 * <p>
 * Design Pattern
 * Object Behavioral / Responsibility - Observer (Dependents, Publish-Subscribe)
 * <p>
 * O padrão Observer define uma dependência um-para-muitos entre objetos, de
 * maneira que quando um objeto muda de estado, todos os seus dependentes são
 * notificados e atualizados automaticamente.
 * <p>
 * Pull-model: modelo simples, os observadores requisitam os dados ao assunto
 * Push-model: modelo completo, o assunto envia os dados para os observadores
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Subject subject = new ConcreteSubject();
    final Observer observer = new ConcreteObserver();

    subject.attach(observer);
    subject.setState("Subject 1");
    subject.setState("Subject 2");
    subject.detach(observer);
    subject.setState("Subject 3");
  }
}
