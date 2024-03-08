package flik;

import static flik.Flik.isSameNumber;
import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    /** Performs a few arbitrary tests to see if the library
     * has any bugs. */

    @Test
    public void testOne() {
        assertTrue(Flik.isSameNumber(3, 3));
        assertTrue(Flik.isSameNumber(-9, -9));
        assertTrue(!Flik.isSameNumber(1000, -1000));
        assertTrue(Flik.isSameNumber(130, 130));
    }
}
