package ch.abbts.swt.swayingcitadell;

import ch.abbts.swt.MathController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
        MathController mcSpy = Mockito.spy(mC);
        Integer actual = mcSpy.add(2, 2);
        assertEquals(expected,actual);
        Mockito.verify(mcSpy, Mockito.times(1)).add(2,2);
    }
}
