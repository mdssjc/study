package br.com.k19.component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Component Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class PosVenda {

  private static final String PATTERN = "dd/MM/yyyy";

  public void agendaContato(final String cliente, final String produto) {
    final Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, 30);
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PosVenda.PATTERN);
    final String format = simpleDateFormat.format(calendar.getTime());

    System.out.println("Entrar em contato com " + cliente + " sobre o produto " + produto + " no dia " + format);
  }
}
