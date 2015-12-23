package argentum.indicadores;

import argentum.modelo.SerieTemporal;

public interface Indicador {

    double calcula(int posicao, SerieTemporal serie);
}
