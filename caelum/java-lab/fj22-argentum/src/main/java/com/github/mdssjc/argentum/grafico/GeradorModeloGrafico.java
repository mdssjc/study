package com.github.mdssjc.argentum.grafico;

import com.github.mdssjc.argentum.indicadores.Indicador;
import org.primefaces.model.chart.ChartModel;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import com.github.mdssjc.argentum.modelo.SerieTemporal;

public class GeradorModeloGrafico {

    private SerieTemporal  serie;
    private int            comeco;
    private int            fim;
    private LineChartModel modeloGrafico;
    private String         tituloGrafico;

    public GeradorModeloGrafico(SerieTemporal serie, int comeco, int fim,
            String tituloGrafico) {
        this.serie = serie;
        this.comeco = comeco;
        this.fim = fim;
        this.tituloGrafico = tituloGrafico;
        this.modeloGrafico = new LineChartModel();
    }

    public void plotaIndicador(Indicador indicador) {
        LineChartSeries chartSerie = new LineChartSeries(indicador.toString());

        for (int i = comeco; i <= fim; i++) {
            double valor = indicador.calcula(i, serie);
            chartSerie.set(i, valor);
        }
        this.modeloGrafico.addSeries(chartSerie);
        this.modeloGrafico.setLegendPosition("w");
        this.modeloGrafico.setTitle(tituloGrafico);
    }

    public ChartModel getModeloGrafico() {
        return this.modeloGrafico;
    }
}
