package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetalhesDoLeilaoPage {

  private final WebDriver driver;

  public DetalhesDoLeilaoPage(final WebDriver driver) {
    this.driver = driver;
  }

  public void lance(final String usuario, final double valor) {
    final WebElement txtValor = this.driver.findElement(By.name("lance.valor"));
    final WebElement combo = this.driver.findElement(
        By.name("lance.usuario.id"));
    final Select cbUsuario = new Select(combo);

    cbUsuario.selectByVisibleText(usuario);
    txtValor.sendKeys(String.valueOf(valor));

    this.driver.findElement(By.id("btnDarLance"))
               .click();
  }

  public boolean existeLance(final String usuario, final double valor) {
    final Boolean temUsuario = new WebDriverWait(this.driver, 10)
                                                                 .until(
                                                                     ExpectedConditions.textToBePresentInElement(
                                                                         By.id(
                                                                             "lancesDados"),
                                                                         usuario));
    if (temUsuario) {
      return this.driver.getPageSource()
                        .contains(usuario)
          && this.driver.getPageSource()
                        .contains(String.valueOf(valor));
    }
    return false;
  }
}
