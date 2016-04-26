package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UsuariosPage {

  private final WebDriver driver;

  public UsuariosPage(final WebDriver driver) {
    this.driver = driver;
  }

  public void visita() {
    this.driver.get("localhost:8080/usuarios");
  }

  public NovoUsuarioPage novo() {
    this.driver.findElement(By.linkText("Novo Usuário"))
               .click();

    return new NovoUsuarioPage(this.driver);
  }

  public boolean existeNaListagem(final String nome, final String email) {
    return this.driver.getPageSource()
                      .contains(nome)
        &&
        this.driver.getPageSource()
                   .contains(email);
  }
}
