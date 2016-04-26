package com.github.mdssjc.cdc.tas;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;

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
                                                   new Usuario("José da Silva",
                                                       "jose@email.com"),
                                                   2000.0)
                                               .lance(
                                                   new Usuario("Maria Pereira",
                                                       "maria@email.com"),
                                                   2500.0)
                                               .constroi();

    when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
    when(avaliador.getMaiorLance()).thenReturn(2500.0);

    final GeradorDePagamento gerador = new GeradorDePagamento(leiloes,
        pagamentos, avaliador);
    gerador.gera();

    final ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(
        Pagamento.class);
    verify(pagamentos).salva(argumento.capture());

    final Pagamento pagamentoGerado = argumento.getValue();
    assertEquals(2500.0, pagamentoGerado.getValor(), 0.00001);
  }

  @Test
  public void deveEmpurrarParaOProximoDiaUtil() {
    final RepositorioDeLeiloes leiloes = mock(RepositorioDeLeiloes.class);
    final RepositorioDePagamentos pagamentos = mock(
        RepositorioDePagamentos.class);
    final Relogio relogio = mock(Relogio.class);

    final Leilao leilao = new CriadorDeLeilao()
                                               .para("Playstation")
                                               .lance(
                                                   new Usuario("José da Silva",
                                                       "jose@email.com"),
                                                   2000.0)
                                               .lance(
                                                   new Usuario("Maria Pereira",
                                                       "maria@email.com"),
                                                   2500.0)
                                               .constroi();

    final Calendar sabado = Calendar.getInstance();
    sabado.set(2012, Calendar.APRIL, 7);

    when(leiloes.encerrados()).thenReturn(Arrays.asList(leilao));
    when(relogio.hoje()).thenReturn(sabado);

    final GeradorDePagamento gerador = new GeradorDePagamento(leiloes,
        pagamentos, new Avaliador(), relogio);
    gerador.gera();

    final ArgumentCaptor<Pagamento> argumento = ArgumentCaptor.forClass(
        Pagamento.class);
    verify(pagamentos).salva(argumento.capture());

    final Pagamento pagamentoGerado = argumento.getValue();
    assertEquals(Calendar.MONDAY, pagamentoGerado.getData()
                                                 .get(Calendar.DAY_OF_WEEK));
  }
}
