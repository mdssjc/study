package app;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LanceSystemTest {

  private WebDriver   driver;
  private LeiloesPage leiloes;

  @Before
  public void criaCenario() {
    this.driver = new FirefoxDriver();
    this.driver.get("http://localhost:8080/apenas-teste/limpa");

    this.leiloes = new LeiloesPage(this.driver);

    new CriadorDeCenarios(this.driver)
                                      .umUsuario("Paulo Henrique",
                                          "paulo@henrique.com")
                                      .umUsuario("José Alberto",
                                          "jose@alberto.com")
                                      .umLeilao("Paulo Henrique", "Geladeira",
                                          100,
                                          false);
  }

  @After
  public void encerra() {
    this.driver.close();
  }

  @Test
  public void deveFazerUmLance() {
    final DetalhesDoLeilaoPage lances = this.leiloes.detalhes(1);

    lances.lance("José Alberto", 150);

    assertTrue(lances.existeLance("José Alberto", 150));
  }

}
