package app;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UsuariosSystemTest {

  private WebDriver    driver;
  private UsuariosPage usuarios;

  @Before
  public void inicializa() {
    this.driver = new FirefoxDriver();
    this.usuarios = new UsuariosPage(this.driver);
  }

  @After
  public void encerra() {
    this.driver.close();
  }

  @Test
  public void deveAdicionarUmUsuario() {
    this.usuarios.visita();
    this.usuarios.novo()
                 .cadastra("Ronaldo Luiz de Albuquerque",
                     "ronaldo2009@terra.com.br");

    assertTrue(this.usuarios.existeNaListagem("Ronaldo Luiz de Albuquerque",
        "ronaldo2009@terra.com.br"));
  }
}
