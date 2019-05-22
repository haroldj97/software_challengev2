package calculate;

// IMPORT JTable from the javax swing package
import javax.swing.JTable;

/**
 * This is the IcalculateExcludedArea interface. It is implemented by calculateExcludedArea and returns the area which shouldn't be painted 
 * 
 * @author harry
 * @version 0.1
 */
public interface IcalculateExcludedArea {
   
    /**
     * METHOD: calculateExclusion calculates the total area of items that should not be painted. uses the values which
     *         have been entered into the table 
     * 
     * @param iTable is a reference to the table that holds all the values
     * @return a double which is the total area which should be excluded
     */
    double calculateExclusion(JTable iTable);
    
}
