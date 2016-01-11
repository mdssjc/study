package br.com.k19.interceptadores;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggingInterceptor {

    @AroundInvoke
    public Object interceptador(InvocationContext ic) throws Exception {
        System.out.println("Chamando o método: " + ic.getMethod());

        Object retornoDoMetodoNegocio = ic.proceed();

        System.out.println("Método " + ic.getMethod() + " finalizado");

        return retornoDoMetodoNegocio;
    }
}
