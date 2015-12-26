import static org.junit.Assert.assertEquals;

import org.junit.Test;

import argentum.indicadores.Indicador;
import argentum.indicadores.factory.IndicadorFactory;

public class IndicadorFactoryTest {

    @Test
    public void configuradoComNulo() {
        IndicadorFactory factory = new IndicadorFactory("MediaMovelSimples",
                null);
        Indicador indicador = factory.defineIndicador();

        assertEquals("MediaMovelSimples", indicador.getClass()
                                                   .getSimpleName());
    }

    @Test
    public void configuradoParaMediaSimples() {
        IndicadorFactory factory = new IndicadorFactory("MediaMovelSimples",
                "IndicadorFechamento");
        Indicador indicador = factory.defineIndicador();

        assertEquals("MediaMovelSimples", indicador.getClass()
                                                   .getSimpleName());
    }

    @Test
    public void configuradoParaMediaPonderada() {
        IndicadorFactory factory = new IndicadorFactory("MediaMovelPonderada",
                "IndicadorFechamento");
        Indicador indicador = factory.defineIndicador();

        assertEquals("MediaMovelPonderada", indicador.getClass()
                                                     .getSimpleName());
    }

    @Test(expected = RuntimeException.class)
    public void testName() {
        IndicadorFactory factory = new IndicadorFactory("a", "b");
        factory.defineIndicador();
    }
}
