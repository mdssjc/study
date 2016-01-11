package br.com.k19.interceptadores;

import java.util.ArrayList;
import java.util.List;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import br.com.k19.entidades.Mensagem;

public class CensuraInteceptor {

    private List<String> palavrasProibidas = new ArrayList<>();

    public CensuraInteceptor() {
        palavrasProibidas.add("coca-cola");
        palavrasProibidas.add("fiat");
        palavrasProibidas.add("sony");
    }

    @AroundInvoke
    public Object interceptador(InvocationContext ic) throws Exception {
        Object[] parameters = ic.getParameters();
        Mensagem mensagem = (Mensagem) parameters[0];

        for (String palavaProibida : palavrasProibidas) {
            String textoOriginal = mensagem.getTexto();
            String textoCensurado = textoOriginal.replaceAll(palavaProibida,
                    "!CENSURADO!");
            mensagem.setTexto(textoCensurado);
        }

        return ic.proceed();
    }
}
