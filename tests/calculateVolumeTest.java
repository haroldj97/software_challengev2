package calculate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for calculateVolume
 *
 * @author harry
 * @version 0.1
 *
 * Test Conditions:
 *
 * calculateVolume: correctly calculates the volume of the room by returning a value which is not 0
 *
 */
public class calculateVolumeTest {

    @Test
    public void calculateTest1(){

        IcalculateVolume _testInstance = new calculateVolume();

        double rtnValue = _testInstance.volumeCalculation(10,10,2.4);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

    @Test
    public void calculateTest2(){

        IcalculateVolume _testInstance = new calculateVolume();

        double rtnValue = _testInstance.volumeCalculation(7.5,2.5,2.4);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

    @Test
    public void calculateTest3(){

        IcalculateVolume _testInstance = new calculateVolume();

        double rtnValue = _testInstance.volumeCalculation(6.56,4.2,2.4);

        assertTrue(rtnValue > 0, "The return value is not greater than 0");
    }

}