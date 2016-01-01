package br.com.k19.sessionbeans;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {

    private static final int WAIT     = 100;
    private Random           gerador  = new Random();
    private static int       contador = 0;

    @PostConstruct
    public void inicializando() {
        synchronized (LancadorDeDadoBean.class) {
            LancadorDeDadoBean.contador++;
            System.out.println("Criando um lançador de dado...");
            System.out.println("Total: " + LancadorDeDadoBean.contador);
        }
    }

    @PreDestroy
    public void destruindo() {
        synchronized (LancadorDeDadoBean.class) {
            LancadorDeDadoBean.contador--;
            System.out.println("Destruindo um lançador de dado...");
            System.out.println("Total: " + LancadorDeDadoBean.contador);
        }
    }

    @Override
    public int lanca() {
        return gerador.nextInt(6) + 1;
    }

    @Override
    @Asynchronous
    public Future<Map<Integer, Integer>> calculaFrequencia() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);

        for (int i = 0; i < 500; i++) {
            int v = lanca();
            map.put(v, map.get(v) + 1);
            try {
                Thread.sleep(WAIT);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            System.out.println(i);
        }

        return new AsyncResult<Map<Integer, Integer>>(map);
    }
}
