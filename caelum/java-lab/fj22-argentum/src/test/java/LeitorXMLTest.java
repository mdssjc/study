import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import argentum.modelo.Negociacao;
import argentum.reader.LeitorXML;

public class LeitorXMLTest {

    @Test
    public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
        String xmlDeTeste = "<list>" +
                "  <negociacao>" +
                "    <preco>43.5</preco>" +
                "    <quantidade>1000</quantidade>" +
                "    <data>" +
                "      <time>1322233344455</time>" +
                "    </data>" +
                "  </negociacao>" +
                "</list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);
        
        assertEquals(1, negociacoes.size());
        assertEquals(43.5, negociacoes.get(0).getPreco(), 0.001);
        assertEquals(1000, negociacoes.get(0).getQuantidade());
    }
    
    @Test
    public void carregaXmlComZeroNegociacao() {
        String xmlDeTeste = "<list></list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);
        
        assertEquals(true, negociacoes.isEmpty()); 
    }
    
    @Test
    public void carregaXmlComPrecoFaltando() {
        String xmlDeTeste = "<list>" +
                "  <negociacao>" +
                "    <quantidade>1000</quantidade>" +
                "    <data>" +
                "      <time>1322233344455</time>" +
                "    </data>" +
                "  </negociacao>" +
                "</list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);
        
        assertEquals(1, negociacoes.size());
        assertEquals(1000, negociacoes.get(0).getQuantidade());
    }
    
    @Test
    public void carregaXmlComTresNegociacoes() {
        String xmlDeTeste = "<list>" +
                "  <negociacao>" +
                "    <preco>43.5</preco>" +
                "    <quantidade>1000</quantidade>" +
                "    <data>" +
                "      <time>1322233344455</time>" +
                "    </data>" +
                "  </negociacao>" +
                "  <negociacao>" +
                "    <preco>39.5</preco>" +
                "    <quantidade>1000</quantidade>" +
                "    <data>" +
                "      <time>1322233344455</time>" +
                "    </data>" +
                "  </negociacao>" +
                "  <negociacao>" +
                "    <preco>40.2</preco>" +
                "    <quantidade>1000</quantidade>" +
                "    <data>" +
                "      <time>1322233344455</time>" +
                "    </data>" +
                "  </negociacao>" +
                "</list>";

        LeitorXML leitor = new LeitorXML();
        InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
        List<Negociacao> negociacoes = leitor.carrega(xml);
        
        assertEquals(3, negociacoes.size());
        assertEquals(43.5, negociacoes.get(0).getPreco(), 0.001);
        assertEquals(1000, negociacoes.get(0).getQuantidade());
        assertEquals(39.5, negociacoes.get(1).getPreco(), 0.001);
        assertEquals(1000, negociacoes.get(1).getQuantidade());
        assertEquals(40.2, negociacoes.get(2).getPreco(), 0.001);
        assertEquals(1000, negociacoes.get(2).getQuantidade());
    }
}