package br.com.k19.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class LookupFactory {

    private static final String APP       = "carrinhoWeb";
    private static final String BEAN      = "CarrinhoBean";
    private static final String INTERFACE = "Carrinho";

    @SuppressWarnings("unused")
    public static Object makeLookUp() throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,
                "org.jboss.naming.remote.client.InitialContextFactory");
        properties.put("jboss.naming.client.ejb.context", true);
        properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");

        Context ctx = new InitialContext(properties);

        Object lookup = ctx.lookup(
                APP + "/" + BEAN + "!br.com.k19.sessionbeans." + INTERFACE);

        return lookup;
    }
}
