package argentum.indicadores;

import argentum.modelo.Candlestick;
import argentum.modelo.SerieTemporal;

public class MediaMovelSimples {

    public double calcula(int posicao, SerieTemporal serie) {
        double soma = 0.0;
        for (int i = posicao; i > posicao - 3; i--) {
            Candlestick c = serie.getCandle(i);
            soma += c.getFechamento();
        }
        return soma / 3;
    }

}
