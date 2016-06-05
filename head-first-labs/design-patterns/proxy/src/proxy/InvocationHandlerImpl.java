package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import subject.Subject;

public class InvocationHandlerImpl implements InvocationHandler {

  private final Subject subject;

  public InvocationHandlerImpl(final Subject subject) {
    this.subject = subject;
  }

  @Override
  public Object invoke(final Object proxy, final Method method,
      final Object[] args)
      throws IllegalAccessException, IllegalArgumentException,
      InvocationTargetException {

    if (method.getName()
              .equals("secretMessage")) {
      throw new IllegalAccessException("Unauthorized");
    }

    return method.invoke(this.subject, args);
  }
}
