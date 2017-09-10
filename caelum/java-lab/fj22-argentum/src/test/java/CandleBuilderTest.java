import com.github.mdssjc.argentum.modelo.CandleBuilder;
import org.junit.Test;

public class CandleBuilderTest {

  @Test(expected = IllegalStateException.class)
  public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
    CandleBuilder builder = new CandleBuilder();
    builder.geraCandle();
  }
}
