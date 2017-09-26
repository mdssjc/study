package com.github.mdssjc.argentum.beans;

import com.github.mdssjc.argentum.grafico.GeradorModeloGrafico;
import com.github.mdssjc.argentum.indicadores.factory.IndicadorFactory;
import com.github.mdssjc.argentum.modelo.Candle;
import com.github.mdssjc.argentum.modelo.CandleFactory;
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
    private List<Negociacao>  negociacoes;
    private ChartModel        modeloGrafico;
    private String            nomeMedia;
    private String            nomeIndicadorBase;
    private String            titulo;

    public ArgentumBean() {
        this.negociacoes = new ClienteWebService().getNegociacoes();
        geraGrafico();
    }

    public List<Negociacao> getNegociacoes() {
        return negociacoes;
    }

    public ChartModel getModeloGrafico() {
        return this.modeloGrafico;
    }

    public String getNomeMedia() {
        return nomeMedia;
    }

    public void setNomeMedia(String nomeMedia) {
        this.nomeMedia = nomeMedia;
    }

    public String getNomeIndicadorBase() {
        return nomeIndicadorBase;
    }

    public void setNomeIndicadorBase(String nomeIndicadorBase) {
        this.nomeIndicadorBase = nomeIndicadorBase;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void geraGrafico() {
        System.out.println(
                "PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase);
        List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
        SerieTemporal serie = new SerieTemporal(candles);

        GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2,
                serie.getUltimaPosicao(), titulo);
        IndicadorFactory factory = new IndicadorFactory(nomeMedia,
                nomeIndicadorBase);
        geradorGrafico.plotaIndicador(factory.defineIndicador());
        this.modeloGrafico = geradorGrafico.getModeloGrafico();
    }
}