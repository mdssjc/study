package br.com.k19.managebeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.sessionbeans.LancadorDeDado;

@ManagedBean
public class DadoMB {

    @EJB
    private LancadorDeDado lancadorDeDadoBean;

    private int                resultado;

    public void lancaDado() {
        setResultado(lancadorDeDadoBean.lanca());
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
}
