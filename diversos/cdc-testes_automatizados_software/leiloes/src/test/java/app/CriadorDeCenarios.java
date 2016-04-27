package app;

import org.openqa.selenium.WebDriver;

public class CriadorDeCenarios {

  private final WebDriver driver;

  public CriadorDeCenarios(final WebDriver driver) {
    this.driver = driver;
  }

  public CriadorDeCenarios umUsuario(final String nome, final String email) {
    final UsuariosPage usuarios = new UsuariosPage(this.driver);
    usuarios.visita();
    usuarios.novo()
            .cadastra(nome, email);
    return this;
  }

  public CriadorDeCenarios umLeilao(final String usuario, final String produto,
      final double valor, final boolean usado) {
    final LeiloesPage leiloes = new LeiloesPage(this.driver);
    leiloes.visita();
    leiloes.novo()
           .preenche(produto, valor, usuario, usado);
    return this;
  }
}
