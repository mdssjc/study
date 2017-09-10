package com.github.mdssjc.argentum.indicadores;

import com.github.mdssjc.argentum.modelo.SerieTemporal;

public interface Indicador {

    double calcula(int posicao, SerieTemporal serie);
}
