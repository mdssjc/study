package app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeilaoTest {

  @Test
  public void deveAdicionarUmUsuario() {
    final WebDriver driver = new FirefoxDriver();
    driver.get("http://localhost:8080/usuarios/new");

    final WebElement nome = driver.findElement(By.name("usuario.nome"));
    final WebElement email = driver.findElement(By.name("usuario.email"));

    nome.sendKeys("Ronaldo Luiz de Albuquerque");
    email.sendKeys("ronaldo2009@terra.com.br");

    final WebElement botaoSalvar = driver.findElement(By.id("btnSalvar"));
    botaoSalvar.click();

    final boolean achouNome = driver.getPageSource()
                                    .contains("Ronaldo Luiz de Albuquerque");
    final boolean achouEmail = driver.getPageSource()
                                     .contains("ronaldo2009@terra.com.br");

    assertTrue(achouNome);
    assertTrue(achouEmail);

    driver.close();
  }
}
