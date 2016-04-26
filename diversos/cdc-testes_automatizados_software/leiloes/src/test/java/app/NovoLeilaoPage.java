package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NovoLeilaoPage {

  private final WebDriver driver;

  public NovoLeilaoPage(final WebDriver driver) {
    this.driver = driver;
  }

  public void preenche(final String nome, final double valor,
      final String usuario,
      final boolean usado) {
    final WebElement txtNome = this.driver.findElement(By.name("leilao.nome"));
    final WebElement txtValor = this.driver.findElement(
        By.name("leilao.valorInicial"));

    txtNome.sendKeys(nome);
    txtValor.sendKeys(String.valueOf(valor));

    final WebElement combo = this.driver.findElement(
        By.name("leilao.usuario.id"));
    final Select cbUsuario = new Select(combo);
    cbUsuario.selectByVisibleText(usuario);

    if (usado) {
      final WebElement ckUsado = this.driver.findElement(
          By.name("leilao.usado"));
      ckUsado.click();
    }

    txtNome.submit();
  }
}
