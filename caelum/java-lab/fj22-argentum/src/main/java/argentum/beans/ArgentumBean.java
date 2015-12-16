package argentum.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import argentum.modelo.Negociacao;
import argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Negociacao>  negociacoes;

    public ArgentumBean() {
        ClienteWebService webService = new ClienteWebService();
        this.negociacoes = webService.getNegociacoes();
    }

    public List<Negociacao> getNegociacoes() {
        return negociacoes;
    }
}
