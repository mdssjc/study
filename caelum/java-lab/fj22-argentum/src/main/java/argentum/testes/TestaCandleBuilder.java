package argentum.testes;

import java.util.GregorianCalendar;

import argentum.modelo.CandleBuilder;
import argentum.modelo.Candlestick;

public class TestaCandleBuilder {
    public static void main(String[] args) {
        Candlestick candle = new CandleBuilder()
                .comAbertura(40.5)
                .comFechamento(42.3)
                .comMinimo(39.8)
                .comMaximo(45.0)
                .comVolume(145234.20)
                .comData(new GregorianCalendar(2008, 8, 12, 0, 0, 0))
                .geraCandle();

        System.out.println(candle);
    }
}
