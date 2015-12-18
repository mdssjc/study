import org.junit.Test;

import argentum.modelo.SerieTemporal;

public class SerieTemporalTest {

    @Test(expected = IllegalArgumentException.class)
    public void receberListaNula() {
        new SerieTemporal(null);
    }
}
