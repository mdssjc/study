package com.github.mdssjc.matchmaking;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class NonOwnerInvocationHandler implements InvocationHandler {

  private final PersonBean person;

  public NonOwnerInvocationHandler(final PersonBean person) {
    this.person = person;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args)
      throws IllegalAccessException {
    try {
      if (method.getName()
                .startsWith("get")) {
        return method.invoke(this.person, args);
      } else if (method.getName()
                       .equals("setHotOrNotRating")) {
        return method.invoke(this.person, args);
      } else if (method.getName()
                       .startsWith("set")) {
        throw new IllegalAccessException();
      }
    } catch (final InvocationTargetException e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
    return null;
  }
}
