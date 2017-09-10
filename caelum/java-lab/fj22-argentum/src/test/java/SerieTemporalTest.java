import org.junit.Test;

import com.github.mdssjc.argentum.modelo.SerieTemporal;

public class SerieTemporalTest {

    @Test(expected = IllegalArgumentException.class)
    public void receberListaNula() {
        new SerieTemporal(null);
    }
}
