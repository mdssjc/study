package br.com.k19.sessionbeans;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class LancadorDeMoedaBean {

    private String resultado;

    public void lanca() {
        resultado = Math.random() < 0.5 ? "CARA" : "COROA";
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
