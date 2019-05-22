package calculate;

// IMPORT ActionEvent and ActionListener from the java awt event packages
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

// IMPORT JTextFeild from the javax swing package
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 * This is the calculateMain class. It is the main class responsible for dealing with all the calculations. Implements IcalculateMain and ActionListener
 * 
 * @author harry
 * @version 0.2
 */
public class calculateMain implements IcalculateMain, ActionListener {

    // DECLARE a reference to a IcalculateArea, call it areaCalculation
    private final IcalculateArea areaCalculation;
    
    // DECLARE a reference to a IcalculateVolume, call it volumeCalculation
    private final IcalculateVolume volumeCalculation;
        
    // DECLARE a reference to a IcalculatePaint, call it paintCalculation
    private final IcalculatePaint paintCalculation;
    
    // DECLARE a reference to a IcalculateExcludedArea, call it exclusionCalculator
    private final IcalculateExcludedArea exclusionCalculator;
    
    // DECLARE a reference to 4 JTextField's to hold the passed values, call them iLength, iWidth, iHeight and iCoverage
    private JTextField iLength;
    private JTextField iWidth;
    private JTextField iHeight;
    private JTextField iCoverage;
    
    // DECLARE a reference to a JTable which will hold the instance of the table which the user can add dimensions of items i.e. doors which don't
    // need to be painted, call it iTable
    private JTable iTable;
    
    // DECLARE a reference to a JTextArea to which will be used to output the calculated values, call it iOutput
    private JTextArea iOutput;
    
    // DECLARE 4 doubles to hold the calculated area, volume, paint required and excluded area, call them roomArea, roomVolume, requiredPaint and totalExclusion
    private double roomArea;
    private double roomVolume;
    private double requiredPaint;
    private double totalExclusion;

    /**
     * CONSTRUCTOR for the class calculateMain. takes instances of the required dependencies 
     * 
     * @param areaCalculate an instance of IcalculateArea
     * @param volumeCalculate an instance of IcalculateVolume
     * @param paintCalculate an instance of IcalculatePaint
     * @param exclusionCalculate an instance of IcalculateExcludedArea
     */
    public calculateMain(IcalculateArea areaCalculate, IcalculateVolume volumeCalculate, IcalculatePaint paintCalculate, IcalculateExcludedArea exclusionCalculate){
        
        // INITILAISE areaCalculation to the passed areaCalculate
        areaCalculation = areaCalculate;
        
        // INITILAISE volumeCalculation to the passed volumeCalculate
        volumeCalculation = volumeCalculate;
        
        // INITIALISE paintCalculation to the passed paintCalculate
        paintCalculation = paintCalculate;
        
        // INITIALISE exclusionCalculator to the passed exclusionCalculate
        exclusionCalculator = exclusionCalculate;
        
    }
    
    /**
     * METHOD: setupCalculate is used to set up the class and initialise the required variables
     * 
     * @param length a reference to the length input box
     * @param width a reference to the width input box
     * @param height a reference to the height input box
     * @param output a reference to the output text area
     * @param exclusionTable a reference to the exclusion table
     */
    @Override
    public void setupCalculate(JTextField length, JTextField width, JTextField height, JTextField coverage, JTextArea output, JTable exclusionTable) {
       
        // INITIALISE iLength, iWidth, iHeight, iCoverage, iOutput and iTable to the appropriate passed parameters
        iLength = length;
        iWidth = width;
        iHeight = height;
        iCoverage = coverage;
        iOutput = output;
        iTable = exclusionTable;
        
    }
    
    /**
     * METHOD actionPerformed is a required method from ActionListener. called when a button click happens
     * 
     * @param e is the event
     * 
     */
     @Override
    public void actionPerformed(ActionEvent e) {

         // IF table is being edited...
         if(iTable.isEditing()){

             // STOP cell editing by using getCellEditor.stopCellEditing method. this is required since the last cell that is edited isn't correctly
             // set otherwise
             iTable.getCellEditor().stopCellEditing();

         }

         // DECLARE a DefaultTableModel to get the table model which is being used, used to get the data from the table
         DefaultTableModel model = (DefaultTableModel) iTable.getModel();

         // DECLARE a variables to hold the total number of rows in the table by using getRowCount
         int nRow = iTable.getRowCount();

         // DECLARE a boolean to hold whether the values in the table are all numbers
         boolean valid = false;

         // FOR LOOP to iterate through the values in the table
         for (int a = 0; a  < nRow; a++) {

             // DECLARE 2 temp variables to hold the values in the current row. have to be converted to a string first since the value is currently of type object
             String heightTemp = (String)model.getValueAt(a, 0);
             String widthTemp = (String)model.getValueAt(a, 1);

             // IF both heightTemp and widthTemp match the regular expression to check whether the row contains just a number...
             if(heightTemp.matches("^\\d+(\\.\\d{1,2})?$") && widthTemp.matches("^\\d+(\\.\\d{1,2})?$")){

                 // UPDATE valid to true
                 valid = true;


             }
             // ELSE..
             else{

                 // UPDATE valid to false
                 valid = false;

                 // EXIT the loop
                 break;

             }

         }


        // IF the value inside of the length, width, height and coverage input box is not equal to "", essentially not empty and valid is true...
        if(!"".equals(iLength.getText()) && !"".equals(iWidth.getText()) && !"".equals(iHeight.getText()) && !"".equals(iCoverage.getText()) && valid){
            
            // IF the value inside of the length, width , height and coverage input box matches the reqular expression, which checks if it is just a number in the input boxes...
            if(iLength.getText().matches(".*\\d.*") && iWidth.getText().matches(".*\\d.*") && iHeight.getText().matches(".*\\d.*") && iCoverage.getText().matches(".*\\d.*")) {
      
                // CONVERT the value inside the input boxes to a double, required since calculations need to be performed with the value
                double convertedLength = Double.parseDouble(iLength.getText());
                double convertedWidth = Double.parseDouble(iWidth.getText());
                double convertedHeight = Double.parseDouble(iHeight.getText());
                double convertedCoverage = Double.parseDouble(iCoverage.getText());
                
                // if the value inside all of the input boxes is greater than 0...
                if(convertedLength > 0 && convertedWidth > 0 && convertedHeight > 0 && convertedCoverage > 0){
                               
                    // CALL areaCalculation by using the instance areaCalculation, passing convertedLength and convertedWidth as parameters, storing the return value in roomArea
                    roomArea = areaCalculation.areaCalculation(convertedLength, convertedWidth);

                    // CALL volumeCalculation by using the volumeCalculation class, passing convertedLength, convertedWidth and convertedHeight as parameters, storing the return value in roomVolume
                    roomVolume = volumeCalculation.volumeCalculation(convertedLength, convertedWidth, convertedHeight);

                    // CALL calculateExclusion by using the exclusionCalculator class, passing iTable as a parameter and storing the return value in totalExclusion
                    totalExclusion = exclusionCalculator.calculateExclusion(iTable);
                    
                    // CALL calculatePaint by using the paintCalculation class, passing convertedLength, convertedWidth, convertedHeight and convertedCoverage 
                    // as parameters, storing the return value in requiredPaint
                    requiredPaint = paintCalculation.calculatePaint(convertedLength, convertedWidth, convertedHeight, convertedCoverage, totalExclusion);

                    // IF requiredPaint is less than 0, meaning the values entered don't add up...
                    if(requiredPaint <= 0){

                        // UPDATE the text inside of the iOutput text area to state that the values entered don't add up
                        iOutput.setText("Please re-check the values entered since it seems \nthe excluded dimensions entered are greater than the room size");

                    }
                    // ELSE output all the calculated values
                    else {

                        // UPDATE the text inside of the iOutput text area to the values of roomArea, roomVolume and requiredPaint
                        iOutput.setText("Room Area: " + String.valueOf(roomArea) + " metres squared \nRoom Volume: " + String.valueOf(roomVolume) +
                                " metres cubed \nPaint Required: " + String.valueOf(requiredPaint) + " litres (approximately for one coat)");

                    }
    
                }
                // ELSE IF the values aren't greater than 0...
                else{
                    
                    // UPDATE the text inside of the iOutput text area to state that only numbers can be entered
                    iOutput.setText("Please enter values greater than 0"); 
                    
                }
            }
            // ELSE if the one or more of the input boxes don't match the regular expression...
            else{
                
                // UPDATE the text inside of the iOutput text area to state that only numbers can be entered
                iOutput.setText("Please ensure you enter only numbers");
                
            }
            
        }
        // ELSE IF valid is false
        else if(!valid){

            // UPDATE the text inside of the iOutput text area to state that all the input boxes need to be filled
            iOutput.setText("Please ensure the table only contains numbers");

            
        }
        // ELSE one or more of the input boxes are equal to "", meaning they are empty...
        else{

            // UPDATE the text inside of the iOutput text area to state that all the input boxes need to be filled
            iOutput.setText("Please ensure you fill out all the boxes");

        }
        
    }
   
}
