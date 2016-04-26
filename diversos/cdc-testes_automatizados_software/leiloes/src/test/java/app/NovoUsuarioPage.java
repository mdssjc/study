package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NovoUsuarioPage {

  private final WebDriver driver;

  public NovoUsuarioPage(final WebDriver driver) {
    this.driver = driver;
  }

  public void cadastra(final String nome, final String email) {
    final WebElement txtNome = this.driver.findElement(By.name("usuario.nome"));
    final WebElement txtEmail = this.driver.findElement(
        By.name("usuario.email"));

    txtNome.sendKeys(nome);
    txtEmail.sendKeys(email);

    txtNome.submit();
  }
}
