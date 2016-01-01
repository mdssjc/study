package br.com.k19.sessionbeans;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

@Stateful
@Remote(Carrinho.class)
@StatefulTimeout(value = 1, unit = TimeUnit.MINUTES)
public class CarrinhoBean implements Carrinho {

    private Set<String> produtos = new HashSet<>();
    public static int   contadorTotal;
    public static int   contadorAtivos;
    private int         id;

    @PostConstruct
    public void postConstruct() {
        synchronized (CarrinhoBean.class) {
            CarrinhoBean.contadorTotal++;
            CarrinhoBean.contadorAtivos++;
            id = CarrinhoBean.contadorTotal;

            System.out.println("PostConstruct");
            System.out.println("ID: " + id);
            System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
            System.out.println(
                    "ContadorAtivos: " + CarrinhoBean.contadorAtivos);
        }
    }

    @PrePassivate
    public void prePassivate() {
        synchronized (CarrinhoBean.class) {
            CarrinhoBean.contadorAtivos--;

            System.out.println("PrePassivate");
            System.out.println("ID: " + id);
            System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
            System.out.println(
                    "ContadorAtivos: " + CarrinhoBean.contadorAtivos);
        }
    }

    @PostActivate
    public void postActivate() {
        synchronized (CarrinhoBean.class) {
            CarrinhoBean.contadorAtivos++;

            System.out.println("PostActivate");
            System.out.println("ID: " + id);
            System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
            System.out.println(
                    "ContadorAtivos: " + CarrinhoBean.contadorAtivos);
        }
    }

    @PreDestroy
    public void preDestroy() {
        synchronized (CarrinhoBean.class) {
            CarrinhoBean.contadorAtivos--;

            System.out.println("PreDestroy");
            System.out.println("ID: " + id);
            System.out.println("ContadorTotal: " + CarrinhoBean.contadorTotal);
            System.out.println(
                    "ContadorAtivos: " + CarrinhoBean.contadorAtivos);
        }
    }

    @Override
    public void adiciona(String produto) {
        produtos.add(produto);
    }

    @Override
    public void remove(String produto) {
        produtos.remove(produto);
    }

    @Override
    public Set<String> getProdutos() {
        return produtos;
    }

    @Remove
    @Override
    public void finalizaCompra() {
        System.out.println("Finalizando a compra");
    }
}
