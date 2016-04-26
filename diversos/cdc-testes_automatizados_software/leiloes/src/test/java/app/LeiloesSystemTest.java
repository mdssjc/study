package app;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LeiloesSystemTest {

  private WebDriver   driver;
  private LeiloesPage leiloes;

  @Before
  public void inicializa() {
    this.driver = new FirefoxDriver();
    this.leiloes = new LeiloesPage(this.driver);

    UsuariosPage usuarios = new UsuariosPage(driver);
    usuarios.visita();
    usuarios.novo()
            .cadastra("Paulo Henrique", "paulo@henrique.com");
  }

  @After
  public void encerra() {
    this.driver.close();
  }

  @Test
  public void deveCadastrarUmLeilao() {
    this.leiloes.visita();
    final NovoLeilaoPage novoLeilao = this.leiloes.novo();
    novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);

    assertTrue(this.leiloes.existe("Geladeira", 123, "Paulo Henrique", true));
  }
}
