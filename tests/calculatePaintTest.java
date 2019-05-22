package calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for calculatePaint
 *
 * @author harry
 * @version 0.1
 *
 * Test Conditions:
 *
 * calculatePaint: correctly calculates the paint required by returning a value which is not 0
 */

public class calculatePaintTest {

    @Test
    public void calculateTest1(){

        IcalculatePaint _testInstance = new calculatePaint();

        double rtnValue = _testInstance.calculatePaint(10,10,2.4,12,3.5);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

    @Test
    public void calculateTest2(){

        IcalculatePaint _testInstance = new calculatePaint();

        double rtnValue = _testInstance.calculatePaint(7,9,2.4,10,2.25);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

    @Test
    public void calculateTest3(){

        IcalculatePaint _testInstance = new calculatePaint();

        double rtnValue = _testInstance.calculatePaint(14,9,2.4,15,6.25);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

}