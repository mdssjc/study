package br.com.k19.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.k19.sessionbeans.Carrinho;

public class Recursos {

    @SuppressWarnings("unused")
    public static Carrinho getCarrinho() throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        Context ctx = new InitialContext(properties);

        Carrinho carrinho = (Carrinho) ctx.lookup(
                "carrinhoWeb/CarrinhoBean!br.com.k19.sessionbeans.Carrinho");

        return carrinho;
    }
}
