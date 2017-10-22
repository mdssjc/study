package com.github.mdssjc.argentum.grafico;

import com.github.mdssjc.argentum.indicadores.Indicador;
import com.github.mdssjc.argentum.modelo.SerieTemporal;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

public class GeradorModeloGrafico {

  private final SerieTemporal serie;
  private final int comeco;
  private final int fim;
  private final LineChartModel modeloGrafico;
  private final String tituloGrafico;

  public GeradorModeloGrafico(final SerieTemporal serie, final int comeco, final int fim, final String tituloGrafico) {
    this.serie = serie;
    this.comeco = comeco;
    this.fim = fim;
    this.tituloGrafico = tituloGrafico;
    this.modeloGrafico = new LineChartModel();
  }

  public void plotaIndicador(final Indicador indicador) {
    final LineChartSeries chartSerie = new LineChartSeries(indicador.toString());

    for (int i = this.comeco; i <= this.fim; i++) {
      final double valor = indicador.calcula(i, this.serie);
      chartSerie.set(i, valor);
    }
    this.modeloGrafico.addSeries(chartSerie);
    this.modeloGrafico.setLegendPosition("w");
    this.modeloGrafico.setTitle(this.tituloGrafico);
  }

  public ChartModel getModeloGrafico() {
    return this.modeloGrafico;
  }
}
