package argentum.beans;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import argentum.grafico.GeradorModeloGrafico;
import argentum.indicadores.Indicador;
import argentum.indicadores.IndicadorFechamento;
import argentum.indicadores.MediaMovelSimples;
import argentum.modelo.Candle;
import argentum.modelo.CandleFactory;
import argentum.modelo.Negociacao;
import argentum.modelo.SerieTemporal;
import argentum.ws.ClienteWebService;

@ManagedBean
@ViewScoped
public class ArgentumBean implements Serializable {

    private static final int  INTERVALO        = 3;
    private static final long serialVersionUID = 1L;
    private List<Negociacao>  negociacoes;
    private ChartModel        modeloGrafico;
    private String            nomeMedia;
    private String            nomeIndicadorBase;

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

    public void geraGrafico() {
        System.out.println(
                "PLOTANDO: " + nomeMedia + " de " + nomeIndicadorBase);
        List<Candle> candles = new CandleFactory().constroiCandles(negociacoes);
        SerieTemporal serie = new SerieTemporal(candles);

        GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2,
                serie.getUltimaPosicao());
        geradorGrafico.plotaIndicador(defineIndicador());
        this.modeloGrafico = geradorGrafico.getModeloGrafico();
    }

    public Indicador defineIndicador() {
        if (nomeIndicadorBase == null || nomeMedia == null) {
            return new MediaMovelSimples(new IndicadorFechamento(), INTERVALO);
        }

        try {
            String pacote = "argentum.indicadores.";
            Class<?> classeIndicadorBase = Class.forName(
                    pacote + nomeIndicadorBase);
            Indicador indicadorBase = (Indicador) classeIndicadorBase.newInstance();

            Class<?> classeMedia = Class.forName(pacote + nomeMedia);
            Constructor<?> construtorMedia = classeMedia.getConstructor(
                    Indicador.class, int.class);

            Indicador indicador = (Indicador) construtorMedia.newInstance(
                    indicadorBase, INTERVALO);

            return indicador;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
