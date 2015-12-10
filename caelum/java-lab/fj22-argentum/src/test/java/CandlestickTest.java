import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import argentum.modelo.Candlestick;

public class CandlestickTest {

    @Test(expected = IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo() {
        new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void dataNaoPodeSerNula() {
        new Candlestick(10, 20, 10, 20, 10000, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void aberturaNaoPodeSerNegativo() {
        new Candlestick(-10, 20, 10, 20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void fechamentoNaoPodeSerNegativo() {
        new Candlestick(10, -20, 10, 20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void minimoNaoPodeSerNegativo() {
        new Candlestick(10, 20, -10, 20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void maximoNaoPodeSerNegativo() {
        new Candlestick(10, 20, 10, -20, 10000, Calendar.getInstance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void volumeNaoPodeSerNegativo() {
        new Candlestick(10, 20, 10, 20, -10000, Calendar.getInstance());
    }

    @Test
    public void quandoAberturaIgualFechamentoEhAlta() {
        Candlestick candle = new Candlestick(10, 10, 10, 20, 10000, Calendar.getInstance());
        assertEquals(true, candle.isAlta());
        assertEquals(false, candle.isBaixa());
    }
}
