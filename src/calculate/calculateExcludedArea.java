/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculate;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * This is the calculateExcludedArea class. it calculates the area of the room which shouldn't be painted based on the values entered into the table
 *
 * @author harry
 * @version 0.1
 */
public class calculateExcludedArea implements IcalculateExcludedArea {
    
    public calculateExcludedArea(){
        
        // do nothing

    }
    
    /**
     * METHOD: calculateExclusion calculates the total area of items that should not be painted. uses the values which
     *         have been entered into the table 
     * 
     * @param iTable is a reference to the table that holds all the values
     * @return a double which is the total area which should be excluded
     */
    @Override
    public double calculateExclusion(JTable iTable){
        
        // DECLARE a double to hold the total excluded area which will be returned, call it excludedArea
        double excludedArea = 0;
        
        // DECLARE a variables to hold the total number of rows in the table by using getRowCount
        int nRow = iTable.getRowCount();

        // DECLARE a DefaultTableModel to get the table model which is being used, used to get the data from the table
        DefaultTableModel model = (DefaultTableModel) iTable.getModel();

        for (int a = 0; a  < nRow; a++) {
        
           // DECLARE 2 temp variables to hold the values in the current row. have to be converted to a string first since the value is currently of type object
           String heightTemp = (String)model.getValueAt(a, 0);
           String widthTemp = (String)model.getValueAt(a, 1);
            
           // UPDATE excludedArea to itself plus the 2 values in the current row multipled together to get the area. they have to parse to doubles since calculations need 
           // to be carried out
           excludedArea += (Double.parseDouble(heightTemp) * Double.parseDouble(widthTemp));
  
        }
           
        // RETURN the excludedArea variable
        return excludedArea;
        
        
    }
    
}
