package com.github.mdssjc.argentum.reader;

import com.github.mdssjc.argentum.modelo.Negociacao;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LeitorXMLTest {

  @Test
  public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
    final String xmlDeTeste = "<list>" +
                              "  <negociacao>" +
                              "    <preco>43.5</preco>" +
                              "    <quantidade>1000</quantidade>" +
                              "    <data>" +
                              "      <time>1322233344455</time>" +
                              "    </data>" +
                              "  </negociacao>" +
                              "</list>";

    final LeitorXML leitor = new LeitorXML();
    final InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
    final List<Negociacao> negociacoes = leitor.carrega(xml);

    assertEquals(1, negociacoes.size());
    assertEquals(43.5, negociacoes.get(0)
                                  .getPreco(), 0.001);
    assertEquals(1000, negociacoes.get(0)
                                  .getQuantidade());
  }

  @Test
  public void carregaXmlComZeroNegociacao() {
    final String xmlDeTeste = "<list></list>";

    final LeitorXML leitor = new LeitorXML();
    final InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
    final List<Negociacao> negociacoes = leitor.carrega(xml);

    assertTrue(negociacoes.isEmpty());
  }

  @Test
  public void carregaXmlComPrecoFaltando() {
    final String xmlDeTeste = "<list>" +
                              "  <negociacao>" +
                              "    <quantidade>1000</quantidade>" +
                              "    <data>" +
                              "      <time>1322233344455</time>" +
                              "    </data>" +
                              "  </negociacao>" +
                              "</list>";

    final LeitorXML leitor = new LeitorXML();
    final InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
    final List<Negociacao> negociacoes = leitor.carrega(xml);

    assertEquals(1, negociacoes.size());
    assertEquals(1000, negociacoes.get(0)
                                  .getQuantidade());
  }

  @Test
  public void carregaXmlComTresNegociacoes() {
    final String xmlDeTeste = "<list>" +
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

    final LeitorXML leitor = new LeitorXML();
    final InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
    final List<Negociacao> negociacoes = leitor.carrega(xml);

    assertEquals(3, negociacoes.size());
    assertEquals(43.5, negociacoes.get(0)
                                  .getPreco(), 0.001);
    assertEquals(1000, negociacoes.get(0)
                                  .getQuantidade());
    assertEquals(39.5, negociacoes.get(1)
                                  .getPreco(), 0.001);
    assertEquals(1000, negociacoes.get(1)
                                  .getQuantidade());
    assertEquals(40.2, negociacoes.get(2)
                                  .getPreco(), 0.001);
    assertEquals(1000, negociacoes.get(2)
                                  .getQuantidade());
  }
}
