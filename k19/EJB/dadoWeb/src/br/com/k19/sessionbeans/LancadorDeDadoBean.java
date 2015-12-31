package br.com.k19.sessionbeans;

import java.util.Random;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {

    private Random gerador = new Random();

    @Override
    public int lanca() {
        return gerador.nextInt(6) + 1;
    }
}
