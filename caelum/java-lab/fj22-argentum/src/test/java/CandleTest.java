import com.github.mdssjc.argentum.modelo.Candle;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class CandleTest {

    @Test(expected = IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo() {
        new Candle(10, 20, 20, 10, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dataNaoPodeSerNula() {
        new Candle(10, 20, 10, 20, 10000, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aberturaNaoPodeSerNegativo() {
        new Candle(-10, 20, 10, 20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void fechamentoNaoPodeSerNegativo() {
        new Candle(10, -20, 10, 20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void minimoNaoPodeSerNegativo() {
        new Candle(10, 20, -10, 20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void maximoNaoPodeSerNegativo() {
        new Candle(10, 20, 10, -20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void volumeNaoPodeSerNegativo() {
        new Candle(10, 20, 10, 20, -10000, Calendar.getInstance());
    }

    @Test
    public void quandoAberturaIgualFechamentoEhAlta() {
        Candle candle = new Candle(10, 10, 10, 20, 10000,
                Calendar.getInstance());
        assertEquals(true, candle.isAlta());
        assertEquals(false, candle.isBaixa());
    }
}
