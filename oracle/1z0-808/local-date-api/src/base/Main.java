package base;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * Local Date API (1Z0-808)
 * Revisão para a certificação.
 *
 * @author mdssjc
 *
 */
public class Main {

  public static void main(final String[] args) {
    new Date();
    Calendar.getInstance();

    // Datas para Computadores
    final Instant instantA = Instant.now();
    for (int i = 0; i < 100_000_000; i++) {
    }
    final Instant instantB = Instant.now();

    final Duration duration = Duration.between(instantA, instantB);
    System.out.println(duration);

    // Datas para Humanos
    // Date
    final LocalDate now = LocalDate.now(); // Immutable
    final LocalDate birthday = LocalDate.of(2016, Month.JULY, 10);
    LocalDate.of(2016, 1, 1); // Month started in 1

    System.out.println(now); // YYYY-MM-dd (ISO-8601)
    System.out.println(birthday);

    final Period period = Period.between(now, birthday); // Immutable

    System.out.printf("%s months and %s days.\n", period.getMonths(),
        period.getDays());
    // Time
    final LocalTime timeNow = LocalTime.now();
    final LocalTime birthtime = LocalTime.of(11, 30);

    System.out.println(timeNow);
    // Date Time
    final LocalDateTime mds = LocalDateTime.of(birthday, birthtime);
    System.out.println(mds);
  }
}
