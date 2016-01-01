package br.com.k19.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import br.com.k19.sessionbeans.LancadorDeDado;

public class Recursos {

    @SuppressWarnings("unused")
    public static LancadorDeDado getLancadorDeDado() throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        Context ctx = new InitialContext(properties);

        LancadorDeDado lancadorDeDado = (LancadorDeDado) ctx.lookup(
                "dadoWeb/LancadorDeDadoBean!br.com.k19.sessionbeans.LancadorDeDado");

        return lancadorDeDado;
    }
}
