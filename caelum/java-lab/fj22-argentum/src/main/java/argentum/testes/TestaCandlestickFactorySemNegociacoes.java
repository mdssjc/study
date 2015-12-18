package argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import argentum.modelo.Candle;
import argentum.modelo.CandleFactory;
import argentum.modelo.Negociacao;

public class TestaCandlestickFactorySemNegociacoes {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();

        List<Negociacao> negociacoes = Arrays.asList();

        CandleFactory fabrica = new CandleFactory();
        Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);

        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());
    }
}
