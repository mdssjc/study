package argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import argentum.modelo.Negociacao;
import argentum.reader.LeitorXML;

public class ClienteWebService {

    private static final String URL_WEBSERVICE = "http://argentumws.caelum.com.br/negociacoes";

    public List<Negociacao> getNegociacoes() {
        HttpURLConnection connection = null;

        try {
            URL url = new URL(URL_WEBSERVICE);
            connection = (HttpURLConnection) url.openConnection();
            InputStream content = connection.getInputStream();

            return new LeitorXML().carrega(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            connection.disconnect();
        }
    }

    /**
     * Execução exemplo de consumo do webservice.
     * 
     * @param args
     */
    public static void main(String[] args) {
        List<Negociacao> negociacoes = new ClienteWebService().getNegociacoes();
        for (Negociacao negociacao : negociacoes) {
            System.out.println(negociacao);
        }
    }
}
