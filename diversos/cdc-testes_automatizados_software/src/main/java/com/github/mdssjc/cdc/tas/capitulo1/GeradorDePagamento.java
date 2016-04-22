package com.github.mdssjc.cdc.tas.capitulo1;

import java.util.Calendar;
import java.util.List;

public class GeradorDePagamento {

  private final RepositorioDeLeiloes    leiloes;
  private final RepositorioDePagamentos pagamentos;
  private final Avaliador               avaliador;

  public GeradorDePagamento(final RepositorioDeLeiloes leiloes,
      final RepositorioDePagamentos pagamentos, final Avaliador avaliador) {
    this.leiloes = leiloes;
    this.pagamentos = pagamentos;
    this.avaliador = avaliador;
  }

  public void gera() {
    final List<Leilao> leiloesEncerrados = this.leiloes.encerrados();
    for (final Leilao leilao : leiloesEncerrados) {
      this.avaliador.avalia(leilao);
    }

    final Pagamento novoPagamento = new Pagamento(
        this.avaliador.getMaiorLance(),
        Calendar.getInstance());
    this.pagamentos.salva(novoPagamento);
  }
}
