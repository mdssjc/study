package aceitacao;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeraGraficoTest {

  private static final String URL = "http://localhost:8080/argentum/index.xhtml";
  private WebDriver driver;

  @Before
  public void setUp() {
    System.setProperty("webdriver.gecko.driver",
                       "/home/mdssjc/java/geckodriver");
    driver = new FirefoxDriver();
    driver.get(URL);
  }

  @After
  public void tearDown() {
    driver.close();
  }

  @Test
  public void testeAoGerarGraficoSemTituloUmaMensagemEhApresentada() {
    WebElement titulo = driver.findElement(By.id("dadosGrafico:titulo"));
    titulo.sendKeys("");
    titulo.sendKeys(Keys.ENTER);

    boolean existeMensagem = driver.getPageSource()
                                   .contains("Erro de validação");

    Assert.assertTrue(existeMensagem);
  }
}
