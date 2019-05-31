package ch.abbts.swt.swayingcitadell;

import ch.abbts.swt.MathController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathControllerTests {
    private MathController mC;

    @Before
    public void initialize() {
        mC = new MathController();
    }

    @Test
    public void addTwoAndTwo() {
        Integer expected = 4;
        Integer actual = mC.add(2, 2);
        assertEquals(expected,actual);
    }
}
