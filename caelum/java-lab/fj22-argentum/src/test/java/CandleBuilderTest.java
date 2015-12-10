import org.junit.Test;

import argentum.modelo.CandleBuilder;

public class CandleBuilderTest {

    @Test(expected = IllegalStateException.class)
    public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
        CandleBuilder builder = new CandleBuilder();
        builder.geraCandle();
    }
}
