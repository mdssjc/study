package proxy;

import java.lang.reflect.Proxy;

import subject.Subject;

public class ProtectionProxy {

  public Subject getProxy(final String clazz) {
    Subject subject;
    try {
      subject = (Subject) Class.forName("subject.real." + clazz)
                               .newInstance();

      return (Subject) Proxy.newProxyInstance(
          subject.getClass()
                 .getClassLoader(),
          subject.getClass()
                 .getInterfaces(),
          new InvocationHandlerImpl(subject));
    } catch (final Exception e) {
      System.err.println(e);
    }
    return null;
  }
}
