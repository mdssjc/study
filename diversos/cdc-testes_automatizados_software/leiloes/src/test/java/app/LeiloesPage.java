package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeiloesPage {

  private final WebDriver driver;

  public LeiloesPage(final WebDriver driver) {
    this.driver = driver;
  }

  public void visita() {
    this.driver.get("localhost:8080/leiloes");
  }

  public NovoLeilaoPage novo() {
    this.driver.findElement(By.linkText("Novo Leilão"))
               .click();
    return new NovoLeilaoPage(this.driver);
  }

  public boolean existe(final String produto, final double valor,
      final String usuario,
      final boolean usado) {
    return this.driver.getPageSource()
                      .contains(produto)
        && this.driver.getPageSource()
                      .contains(String.valueOf(valor))
        && driver.getPageSource()
                 .contains(usuario)
        && this.driver.getPageSource()
                      .contains(usado ? "Sim" : "Não");
  }
}
