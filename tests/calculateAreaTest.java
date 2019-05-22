package calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for calculateArea
 *
 * @author harry
 * @version 0.1
 *
 * Test Conditions:
 *
 * calculateArea: correctly calculates the area of the room by returning a value which is not 0
 *
 */

public class calculateAreaTest {

    @Test
    public void calculateTest1(){

        IcalculateArea _testInstance = new calculateArea();

        double rtnValue = _testInstance.areaCalculation(10,7.5);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

    @Test
    public void calculateTest2(){

        IcalculateArea _testInstance = new calculateArea();

        double rtnValue = _testInstance.areaCalculation(2.5,10);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

    @Test
    public void calculateTest3(){

        IcalculateArea _testInstance = new calculateArea();

        double rtnValue = _testInstance.areaCalculation(2.05,2.45);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }





}