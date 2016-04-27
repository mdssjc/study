package app;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.jayway.restassured.path.xml.XmlPath;

import app.models.Usuario;

public class UsuariosWSTest {

  @Test
  public void deveRetornarListaDeUsuarios() {
    final XmlPath path = given()
                                .header("Accept", "application/xml")
                                .get("/usuarios/xml")
                                .andReturn()
                                .xmlPath();
    System.out.println(path.prettify());
    final Usuario usuario1 = path.getObject("list.usuario[0]",
        Usuario.class);
    final Usuario usuario2 = path.getObject("list.usuario[1]",
        Usuario.class);

    final Usuario esperado1 = new Usuario();
    esperado1.setNome("Mauricio Aniche");
    esperado1.setEmail("mauricio.aniche@caelum.com.br");

    final Usuario esperado2 = new Usuario();
    esperado2.setNome("Guilherme Silveira");
    esperado2.setEmail("guilherme.silveira@caelum.com.br");

    assertEquals(esperado1, usuario1);
    assertEquals(esperado2, usuario2);
  }
}
