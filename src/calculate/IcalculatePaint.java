package calculate;

/**
 * @author harry
 * @version 0.2
 */
public interface IcalculatePaint {
    
    /**
     * METHOD: calculatePaint takes the length, width and height and returns the paint required
     * 
     * @param length is the length of the room
     * @param width is the width of the room
     * @param height is the height of the room
     * @param coverage is the amount the paint covers in metres squared
     * @param excludedArea is the area of the room which shouldn't be painted
     * 
     * @return a double which is the paint required 
     */
    double calculatePaint(double length, double width, double height, double coverage, double excludedArea);
    
}
