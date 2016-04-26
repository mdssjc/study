package com.github.mdssjc.cdc.tas;

import java.util.Calendar;
import java.util.List;

public class GeradorDePagamento {

  private final RepositorioDeLeiloes    leiloes;
  private final RepositorioDePagamentos pagamentos;
  private final Avaliador               avaliador;
  private final Relogio                 relogio;

  public GeradorDePagamento(final RepositorioDeLeiloes leiloes,
      final RepositorioDePagamentos pagamentos, final Avaliador avaliador,
      final Relogio relogio) {
    this.leiloes = leiloes;
    this.pagamentos = pagamentos;
    this.avaliador = avaliador;
    this.relogio = relogio;
  }

  public GeradorDePagamento(final RepositorioDeLeiloes leiloes,
      final RepositorioDePagamentos pagamentos, final Avaliador avaliador) {
    this(leiloes, pagamentos, avaliador, new RelogioDoSistema());
  }

  public void gera() {
    final List<Leilao> leiloesEncerrados = this.leiloes.encerrados();
    for (final Leilao leilao : leiloesEncerrados) {
      this.avaliador.avalia(leilao);
    }

    final Pagamento novoPagamento = new Pagamento(
        this.avaliador.getMaiorLance(),
        primeiroDiaUtil());
    this.pagamentos.salva(novoPagamento);
  }

  private Calendar primeiroDiaUtil() {
    final Calendar data = this.relogio.hoje();
    final int diaDaSemana = data.get(Calendar.DAY_OF_WEEK);

    if (diaDaSemana == Calendar.SATURDAY) {
      data.add(Calendar.DAY_OF_MONTH, 2);
    } else if (diaDaSemana == Calendar.SATURDAY) {
      data.add(Calendar.DAY_OF_MONTH, 1);
    }

    return data;
  }
}
