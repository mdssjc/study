package argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

final public class Candlestick {
    private final double   abertura;
    private final double   fechamento;
    private final double   minimo;
    private final double   maximo;
    private final double   volume;
    private final Calendar data;

    public Candlestick(double abertura, double fechamento, double minimo,
            double maximo, double volume, Calendar data) {
        this.abertura = abertura;
        this.fechamento = fechamento;
        this.minimo = minimo;
        this.maximo = maximo;
        this.volume = volume;
        this.data = data;
    }

    public double getAbertura() {
        return this.abertura;
    }

    public double getFechamento() {
        return this.fechamento;
    }

    public double getMinimo() {
        return this.minimo;
    }

    public double getMaximo() {
        return this.maximo;
    }

    public double getVolume() {
        return this.volume;
    }

    public Calendar getData() {
        return this.data;
    }

    public boolean isAlta() {
        return this.abertura < this.fechamento;
    }

    public boolean isBaixa() {
        return this.abertura > this.fechamento;
    }

    @Override
    public String toString() {
        return String.format(
                "[Abertura %.1f, Fechamento %.1f, Mínima %.1f, Máxima %.1f, Volume %.2f, Data %s]",
                getAbertura(), getFechamento(), getMinimo(), getMaximo(),
                getVolume(),
                new SimpleDateFormat("dd/MM/yyyy").format(getData().getTime()));
    }
}
