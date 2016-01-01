package br.com.k19.testes;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.k19.sessionbeans.LancadorDeDado;

public class TesteCicloDeVidaSLSB {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        Context ctx = new InitialContext(properties);

        for (int i = 0; i < 100; i++) {
            final LancadorDeDado lancadorDeDado = (LancadorDeDado) ctx.lookup(
                    "dadoWeb/LancadorDeDadoBean!br.com.k19.sessionbeans.LancadorDeDado");

            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println(lancadorDeDado.lanca());
                }
            }).start();
        }
    }
}
