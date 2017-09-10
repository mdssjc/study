package com.github.mdssjc.argentum.indicadores.factory;

import java.lang.reflect.Constructor;

import com.github.mdssjc.argentum.indicadores.Indicador;
import com.github.mdssjc.argentum.indicadores.IndicadorFechamento;
import com.github.mdssjc.argentum.indicadores.MediaMovelSimples;

public class IndicadorFactory {

    private static final int INTERVALO = 3;
    private final String     nomeMedia;
    private final String     nomeIndicadorBase;

    public IndicadorFactory(String nomeMedia, String nomeIndicadorBase) {
        this.nomeMedia = nomeMedia;
        this.nomeIndicadorBase = nomeIndicadorBase;
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
