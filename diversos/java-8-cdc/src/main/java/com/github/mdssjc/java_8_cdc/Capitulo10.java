package com.github.mdssjc.java_8_cdc;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Capitulo10 {

  public static void main(final String[] args) {
    final LocalTime agora = LocalTime.now();
    final LocalDate hoje = LocalDate.now();
    final LocalDate amanha = LocalDate.now()
                                      .plusDays(1);
    final LocalDateTime dataEhora = hoje.atTime(agora);

    final ZonedDateTime dataComHoraETimezone = dataEhora.atZone(
        ZoneId.of("America/Sao_Paulo"));
    System.out.println(dataComHoraETimezone);

    System.out.println(hoje.isBefore(amanha));
    System.out.println(hoje.isEqual(amanha));
    System.out.println(hoje.isAfter(amanha));

    final ZonedDateTime tokyo = ZonedDateTime
                                             .of(2011, 5, 2, 10, 30, 0, 0,
                                                 ZoneId.of("Asia/Tokyo"));
    final ZonedDateTime saoPaulo = ZonedDateTime
                                                .of(2011, 5, 2, 10, 30, 0, 0,
                                                    ZoneId.of(
                                                        "America/Sao_Paulo"));
    System.out.println(tokyo.isEqual(saoPaulo));

    final Locale locale = new Locale("pt");
    System.out.println(Month.DECEMBER.firstMonthOfQuarter()
                                     .getDisplayName(TextStyle.FULL, locale));
    System.out.println(Month.DECEMBER.plus(2)
                                     .getDisplayName(TextStyle.FULL, locale));
    System.out.println(Month.DECEMBER.minus(1)
                                     .getDisplayName(TextStyle.FULL, locale));

    System.out.println(hoje.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

    final long dias = ChronoUnit.DAYS.between(hoje, hoje.plusMonths(3));
    System.out.println(dias);

    final Period periodo = Period.between(LocalDate.of(1989, Month.JANUARY, 25),
        hoje);
    // periodo = periodo.negated();
    final Duration duracao = Duration.between(agora, agora.plusHours(2));
    System.out.printf("%s dias, %s meses e %s anos%n",
        periodo.getDays(), periodo.getMonths(), periodo.getYears());
    System.out.printf("%s horas, %s minutos e %s segundos%n",
        duracao.toHours(), duracao.toMinutes(), duracao.getSeconds());
  }
}
