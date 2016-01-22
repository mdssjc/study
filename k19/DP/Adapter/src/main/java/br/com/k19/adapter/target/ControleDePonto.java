package br.com.k19.adapter.target;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.k19.model.Funcionario;

/**
 * Target Adapter Class
 *
 * @author mdssjc
 *
 */
public class ControleDePonto implements ControleDePontoTarget {

  private static final String PATTERN = "dd/MM/yyyy H:m:s";

  @Override
  public void registraEntrada(Funcionario f) {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
    String format = simpleDateFormat.format(calendar.getTime());
    System.out.println("Entrada: " + f.getNome() + " às " + format);
  }

  @Override
  public void registraSaida(Funcionario f) {
    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(PATTERN);
    String format = simpleDateFormat.format(calendar.getTime());
    System.out.println("Saída: " + f.getNome() + " às " + format);
  }
}
