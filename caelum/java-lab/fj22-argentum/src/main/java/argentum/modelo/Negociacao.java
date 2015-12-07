package argentum.modelo;

import java.util.Calendar;

final public class Negociacao {
    private final double   preco;
    private final int      quantidade;
    private final Calendar data;

    public Negociacao(double preco, int quantidade, Calendar data) {
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public Calendar getData() {
        return this.data;
    }

    public double getVolume() {
        return this.preco * this.quantidade;
    }
}
