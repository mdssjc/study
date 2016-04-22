package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class GeradorDePagamentoTest {

  @Test
  public void deveGerarPagamentoParaUmLeilaoEncerrado() {
    final RepositorioDeLeiloes leiloes = mock(RepositorioDeLeiloes.class);
    final RepositorioDePagamentos pagamentos = mock(
        RepositorioDePagamentos.class);
    final Avaliador avaliador = mock(Avaliador.class);

    final Leilao leilao = new CriadorDeLeilao().para("Playstation")
                                               .lance(
                                                   new Usuario("José da Silva"),
                                                   2000.0)
                                               .lance(
                                                   new Usuario("Maria Pereira"),
                                                   2500.0)
                                               .constroi();

    when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
    when(avaliador.getMaiorLance()).thenReturn(2500.0);

    final GeradorDePagamento gerador = new GeradorDePagamento(leiloes,
        pagamentos,
        avaliador);
    gerador.gera();

    final ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(
        Pagamento.class);

    verify(pagamentos).salva(argumento.capture());

    final Pagamento pagamentoGerado = argumento.getValue();
    assertEquals(2500.0, pagamentoGerado.getValor(), 0.00001);
  }
}
