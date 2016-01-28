package br.com.k19.flyweight.factory;

import java.util.HashMap;
import java.util.Map;

import br.com.k19.flyweight.TemaFlyweight;
import br.com.k19.flyweight.concrete.TemaAsterisco;
import br.com.k19.flyweight.concrete.TemaHifen;
import br.com.k19.flyweight.concrete.TemaK19;

/**
 * Factory Flyweight Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class TemaFlyweightFactory {

  private static Map<Class<? extends TemaFlyweight>, TemaFlyweight> temas     = new HashMap<>();

  public static final Class<TemaAsterisco>                          ASTERISCO = TemaAsterisco.class;
  public static final Class<TemaHifen>                              HIFEN     = TemaHifen.class;
  public static final Class<TemaK19>                                K19       = TemaK19.class;

  public static TemaFlyweight getTema(final Class<? extends TemaFlyweight> clazz) {
    if (!TemaFlyweightFactory.temas.containsKey(clazz)) {
      try {
        TemaFlyweightFactory.temas.put(clazz, clazz.newInstance());
      } catch (final InstantiationException e) {
        e.printStackTrace();
      } catch (final IllegalAccessException e) {
        e.printStackTrace();
      }
    }
    return TemaFlyweightFactory.temas.get(clazz);
  }
}
