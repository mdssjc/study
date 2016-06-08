import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class IdentifierTestCase {

   private Identifier id;
   public static final int LIMIT = 200;

   @Before
   public void inicializa() {
      id = new Identifier();
   }

   @Test(timeout = LIMIT)
   public void validate01() {
      boolean obtido;
      obtido = id.validateIdentifier("a1");
      assertEquals(true, obtido);
   }

   @Test(timeout = LIMIT)
   public void validate02() {
      boolean obtido;
      obtido = id.validateIdentifier("");
      assertEquals(false, obtido);
   }

   @Test(timeout = LIMIT)
   public void validate03() {
      boolean obtido;
      obtido = id.validateIdentifier("A1b2C3d");
      assertEquals(false, obtido);
   }

   @Test(timeout = LIMIT)
   public void validate04() {
      boolean obtido;
      obtido = id.validateIdentifier("2B3");
      assertEquals(false, obtido);
   }

   @Test(timeout = LIMIT)
   public void validate05() {
      boolean obtido;
      obtido = id.validateIdentifier("Z#12");
      assertEquals(false, obtido);
   }

   @Test(timeout = LIMIT)
   public void validate06() {
      boolean obtido;
      obtido = id.validateIdentifier("Z");
      assertEquals(true, obtido);
   }

   @Ignore
   @Test(expected = IndexOutOfBoundsException.class)
   public void excecaoString() {
      String str = new String("Exemplo JUnit");
      str.substring(30);
   }
}










