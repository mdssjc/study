import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import argentum.modelo.Negociacao;

public class NegociacaoTest {

    @Test
    public void dataDaNegociacaoEhImutavel() {
        // se criar um negocio no dia 15...
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 15);
        Negociacao n = new Negociacao(10, 5, c);

        // ainda que eu tente mudar a data para 20...
        n.getData()
         .set(Calendar.DAY_OF_MONTH, 20);

        // ele continua no dia 15.
        assertEquals(15, n.getData()
                          .get(Calendar.DAY_OF_MONTH));
    }

    @Test(expected = IllegalArgumentException.class)
    public void naoCriaNegociacaoComDataNula() {
        new Negociacao(10, 5, null);
    }

    @Test
    public void mesmoMilissegundoEhDoMesmoDia() {
        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = (Calendar) agora.clone();

        Negociacao negociacao = new Negociacao(40.0, 100, agora);
        assertTrue(negociacao.isMesmoDia(mesmoMomento));
    }

    @Test
    public void comHorariosDiferentesEhNoMesmoDia() {
        // usando GregorianCalendar(ano, mes, dia, hora, minuto)
        Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, manha);
        assertTrue(negociacao.isMesmoDia(tarde));
    }

    @Test
    public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
        Calendar mes1 = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar mes2 = new GregorianCalendar(2011, 11, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, mes1);
        assertFalse(negociacao.isMesmoDia(mes2));
    }

    @Test
    public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
        Calendar ano1 = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar ano2 = new GregorianCalendar(2012, 10, 20, 15, 30);

        Negociacao negociacao = new Negociacao(40.0, 100, ano1);
        assertFalse(negociacao.isMesmoDia(ano2));
    }
}
