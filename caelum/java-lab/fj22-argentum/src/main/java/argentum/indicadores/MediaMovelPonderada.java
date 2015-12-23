package argentum.indicadores;

import argentum.modelo.Candle;
import argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

    @Override
    public double calcula(int posicao, SerieTemporal serie) {
        double soma = 0.0;
        int peso = 3;

        for (int i = posicao; i > posicao - 3; i--) {
            Candle c = serie.getCandle(i);
            soma += c.getFechamento() * peso;
            peso--;
        }
        return soma / 6;
    }

    @Override
    public String toString() {
        return "MMP de Fechamento";
    }
}
