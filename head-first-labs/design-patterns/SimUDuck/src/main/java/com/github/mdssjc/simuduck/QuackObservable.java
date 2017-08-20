package com.github.mdssjc.simuduck;

public interface QuackObservable {

  void registerObserver(Observer observer);

  void notifyObservers();
}
