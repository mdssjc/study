package argentum.indicadores;

import argentum.modelo.Candle;
import argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

    private int intervalo;

    public MediaMovelPonderada(int intervalo) {
        this.intervalo = intervalo;
    }

    @Override
    public double calcula(int posicao, SerieTemporal serie) {
        double soma = 0.0;
        int peso = intervalo;
        int fatorial = 1;

        for (int i = posicao; i > posicao - intervalo; i--) {
            Candle c = serie.getCandle(i);
            soma += c.getFechamento() * peso;
            peso--;
        }

        for (int i = 1; i <= intervalo; i++) {
            fatorial *= i;
        }

        return soma / fatorial;
    }

    @Override
    public String toString() {
        return "MMP de Fechamento";
    }
}
