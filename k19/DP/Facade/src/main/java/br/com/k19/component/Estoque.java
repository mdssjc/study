package br.com.k19.component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Component Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Estoque {

  private static final String PATTERN = "dd/MM/yyyy";

  public void enviaProduto(final String produto, final String enderecoDeEntrega) {
    final Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, 2);
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Estoque.PATTERN);
    final String format = simpleDateFormat.format(calendar.getTime());

    System.out.println(
        "O produto " + produto + " será entregue no endereço " + enderecoDeEntrega + " até às 18h do dia " + format);
  }
}
