package argentum.modelo;

import java.util.Calendar;

final public class Negociacao {
    private final double   preco;
    private final int      quantidade;
    private final Calendar data;

    public Negociacao(double preco, int quantidade, Calendar data) {
        if (data == null) {
            throw new IllegalArgumentException("data nao pode ser nula");
        }

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
        return (Calendar) this.data.clone();
    }

    public double getVolume() {
        return this.preco * this.quantidade;
    }
}
