package com.github.mdssjc.argentum.beans;

import com.github.mdssjc.argentum.grafico.GeradorModeloGrafico;
import com.github.mdssjc.argentum.indicadores.factory.IndicadorFactory;
import com.github.mdssjc.argentum.modelo.Candlestick;
import com.github.mdssjc.argentum.modelo.CandlestickFactory;
import com.github.mdssjc.argentum.modelo.Negociacao;
import com.github.mdssjc.argentum.modelo.SerieTemporal;
import com.github.mdssjc.argentum.ws.ClienteWebService;
import org.primefaces.model.chart.ChartModel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

  private static final long serialVersionUID = 1L;
  private final List<Negociacao> negociacoes;
  private ChartModel modeloGrafico;
  private String nomeMedia;
  private String nomeIndicadorBase;
  private String titulo;

  public ArgentumBean() {
    this.negociacoes = new ClienteWebService().getNegociacoes();
    geraGrafico();
  }

  public List<Negociacao> getNegociacoes() {
    return this.negociacoes;
  }

  public ChartModel getModeloGrafico() {
    return this.modeloGrafico;
  }

  public String getNomeMedia() {
    return this.nomeMedia;
  }

  public void setNomeMedia(final String nomeMedia) {
    this.nomeMedia = nomeMedia;
  }

  public String getNomeIndicadorBase() {
    return this.nomeIndicadorBase;
  }

  public void setNomeIndicadorBase(final String nomeIndicadorBase) {
    this.nomeIndicadorBase = nomeIndicadorBase;
  }

  public String getTitulo() {
    return this.titulo;
  }

  public void setTitulo(final String titulo) {
    this.titulo = titulo;
  }

  public void geraGrafico() {
    System.out.println(
        "PLOTANDO: " + this.nomeMedia + " de " + this.nomeIndicadorBase);
    final List<Candlestick> candles = new CandlestickFactory().constroiCandles(
        this.negociacoes);
    final SerieTemporal serie = new SerieTemporal(candles);

    final GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2,
                                                                         serie.getUltimaPosicao(),
                                                                         this.titulo);
    final IndicadorFactory factory = new IndicadorFactory(this.nomeMedia,
                                                          this.nomeIndicadorBase);
    geradorGrafico.plotaIndicador(factory.defineIndicador());
    this.modeloGrafico = geradorGrafico.getModeloGrafico();
  }
}
