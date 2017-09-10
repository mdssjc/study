import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.mdssjc.argentum.indicadores.IndicadorFechamento;
import com.github.mdssjc.argentum.indicadores.MediaMovelPonderada;
import com.github.mdssjc.argentum.modelo.SerieTemporal;
import com.github.mdssjc.argentum.testes.GeradorDeSerie;

public class MediaMovelPonderadaTest {

    @Test
    public void sequenciaSimplesDeCandles() {
        SerieTemporal serie = GeradorDeSerie.criaSerie(1, 2, 3, 4, 5, 6);
        MediaMovelPonderada mmp = new MediaMovelPonderada(new IndicadorFechamento(),3);

        // ex: calcula(2): 1*1 + 2*2 + 3*3 = 14.
        // Divide por 6, da 14/6.
        assertEquals(14.0 / 6, mmp.calcula(2, serie), 0.00001);
        assertEquals(20.0 / 6, mmp.calcula(3, serie), 0.00001);
        assertEquals(26.0 / 6, mmp.calcula(4, serie), 0.00001);
        assertEquals(32.0 / 6, mmp.calcula(5, serie), 0.00001);

        mmp = new MediaMovelPonderada(new IndicadorFechamento(),4);

        // ex: calcula(2): 1*1 + 2*2 + 3*3 + 4*4 = 30.
        // Divide por 24, da 30/24.
        assertEquals(30.0 / 24, mmp.calcula(3, serie), 0.00001);
        assertEquals(40.0 / 24, mmp.calcula(4, serie), 0.00001);
        assertEquals(50.0 / 24, mmp.calcula(5, serie), 0.00001);
    }
}
