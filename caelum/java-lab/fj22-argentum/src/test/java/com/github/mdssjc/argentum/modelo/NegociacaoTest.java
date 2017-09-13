package com.github.mdssjc.argentum.modelo;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class NegociacaoTest {

  @Test
  public void dataDaNegociacaoEhImutavel() {
    final Calendar c = Calendar.getInstance();
    c.set(Calendar.DAY_OF_MONTH, 15);
    final Negociacao n = new Negociacao(10, 5, c);

    n.getData()
     .set(Calendar.DAY_OF_MONTH, 20);

    assertEquals(15, n.getData()
                      .get(Calendar.DAY_OF_MONTH));
  }

  @Test(expected = IllegalArgumentException.class)
  public void naoCriaNegociacaoComDataNula() {
    new Negociacao(10, 5, null);
  }

  @Test
  public void mesmoMilissegundoEhDoMesmoDia() {
    final Calendar agora = Calendar.getInstance();
    final Calendar mesmoMomento = (Calendar) agora.clone();

    final Negociacao negociacao = new Negociacao(40.0, 100, agora);
    assertTrue(negociacao.isMesmoDia(mesmoMomento));
  }

  @Test
  public void comHorariosDiferentesEhNoMesmoDia() {
    // usando GregorianCalendar(ano, mes, dia, hora, minuto)
    final Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
    final Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

    final Negociacao negociacao = new Negociacao(40.0, 100, manha);
    assertTrue(negociacao.isMesmoDia(tarde));
  }

  @Test
  public void mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia() {
    final Calendar mes1 = new GregorianCalendar(2011, 10, 20, 8, 30);
    final Calendar mes2 = new GregorianCalendar(2011, 11, 20, 15, 30);

    final Negociacao negociacao = new Negociacao(40.0, 100, mes1);
    assertFalse(negociacao.isMesmoDia(mes2));
  }

  @Test
  public void mesmoDiaEMesMasAnosDiferentesNaoSaoDoMesmoDia() {
    final Calendar ano1 = new GregorianCalendar(2011, 10, 20, 8, 30);
    final Calendar ano2 = new GregorianCalendar(2012, 10, 20, 15, 30);

    final Negociacao negociacao = new Negociacao(40.0, 100, ano1);
    assertFalse(negociacao.isMesmoDia(ano2));
  }
}
