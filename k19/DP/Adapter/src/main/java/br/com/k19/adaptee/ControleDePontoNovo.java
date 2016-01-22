package br.com.k19.adaptee;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.k19.model.Funcionario;

/**
 * Adaptee Class
 *
 * @author mdssjc
 *
 */
public class ControleDePontoNovo {

  private static final String PATTERN = "dd/MM/yyyy H:m:s";

  public void registra(Funcionario f, boolean entrada) {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
    String format = simpleDateFormat.format(calendar.getTime());

    if (entrada) {
      System.out.println("Entrada: " + f.getNome() + " às " + format);
    } else {
      System.out.println("Saída: " + f.getNome() + " às " + format);
    }
  }
}
