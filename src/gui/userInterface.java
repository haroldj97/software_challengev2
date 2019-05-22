package gui;

// IMPORT the FlowLayout from the java awt package
import java.awt.FlowLayout;

// IMPORT everything from the javax swing package
import javax.swing.*;

// IMPORT everything from the calculate package
import calculate.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 * This is the userInterface. It is responsible for setting up the userInterface of the application. Implements IuserInterface
 * 
 * @author harry
 * @version 0.2
 */
public class userInterface implements IuserInterface, ActionListener{
    
    // DECLARE a reference to a IcalculateMain, call it mainCalculate
    private IcalculateMain mainCalculate;
    
    // DECLARE a reference to a JFrame to hold an instance of JFrame, call it mainFrame
    private JFrame mainFrame;
    
    // DECLARE a reference to a JButton to hold an instance of JButton, call it calculate
    private JButton calculate;
    
    // DECLARE a reference to a JButton to hold an instance of JButton to add a row to the table, call it addRow
    private JButton addRow;
    
    // DECLARE a reference to a JTextField to hold an instance of JTextField and be used to take the length of the room, call it length
    private JTextField length;
    
    // DECLARE a reference to a JTextField to hold an instance of JTextField and be used to take the width of the room, call it width
    private JTextField width;
    
    // DECLARE a reference to a JTextField to hold an instance of JTextField and be used to take the height of the room, call it height
    private JTextField height;
    
    // DECLARE a reference to a JTextField to hold an instance of JTextField and be used to take the coverage of the paint, call it coverage
    private JTextField coverage;
    
    // DECLARE a reference to a JLabel to hold an instance of JLabel to be used for the length text field to tell the user what to enter, call it lLabel
    private JLabel lLabel;
    
    // DECLARE a reference to a JLabel to hold an instance of JLabel to be used for the width text field to tell the user what to enter, call it wLabel
    private JLabel wLabel;
    
    // DECLARE a reference to a JLabel to hold an instance of JLabel to be used for the width text field to tell the user what to enter, call it hLabel
    private JLabel hLabel;
    
    // DECLARE a reference to a JLabel to hold an instance of JLabel to be used for the coverage text field to tell the user what to enter, call it cLabel
    private JLabel cLabel;
    
    // DECLARE a reference to a JLabel to hold an instance of JLabel to be used for the exclusion table, call it excludedLabel
    private JLabel excludedLabel;
     
    // DECLARE a reference to a JTextArea to hold an instance of JTextArea to be used to output the calculated values, call it output
    private JTextArea output;
    
    // DECLARE a reference to a JPanel to hold all the components of the interface, call it mainPanel
    private JPanel mainPanel;
    
    // DECLARE a reference to a JScrollPane to hold the table, call it tablePane
    private JScrollPane tablePane;
    
    // DECLARE a reference to a JTable to be used to add items that don't need to be painted, i.e windows, doors, plugs etc. call it exclusionTable
    private JTable exclusionTable;
    
    private DefaultTableModel model;
    
    /**
     * CONSTRUCTOR for the userInterface class
     */
    public userInterface(){
        
        // do nothing 
        
    }
    
    /**
     * METHOD setup is used to setup the user interface for the application
     * 
     * @param calculateMain is an instance of IcalculateMain to be used in this class
     * 
     */
    @Override
    public void setup(IcalculateMain calculateMain){
        
        // INITIALISE mainCalculate to calculateMain;
        mainCalculate = calculateMain;
        
        // INITIALISE mainFrame to a new instance of JFrame, passing the word Calculator to be used as a name for the application
        mainFrame = new JFrame("Calculator");
     
        // INITIALISE mainPanel to a new instance of JPanel
        mainPanel = new JPanel();
        
        mainPanel.setPreferredSize(new Dimension(400,400));
        
        // SET the layout of the mainPanel to a BoxLayout
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // INITIALISE length, width,height and coverage to a new JTextField with line height of 25
        length = new JTextField(25);
        width = new JTextField(25);
        height = new JTextField(25);
        coverage = new JTextField(25);
             
        // INITIALISE output to a new JTextArea width 5 rows, 20 columns
        output = new JTextArea(5,40);
        
        // SET output editable to false so the user cannot add text
        output.setEditable(false);
       
        // INITIALISE lLabel, wLabel, hLabel and cLabel to a new JLabel
        lLabel = new JLabel("Enter the length of the room (in metres): ");
        wLabel = new JLabel("Enter the width of the room (in metres): ");
        hLabel = new JLabel("Enter the height of the room (in metres): ");
        cLabel = new JLabel("<html>Enter the approximate coverage per litre of the paint being used. <br> Usually specified on the paint can in metres squared.</html>");
        excludedLabel = new JLabel("<html>Enter the dimensions in metres of items that shouldn't be painted <br>i.e door, windows etc. Use the 'Add Item' button to add another item to the table</html>");
 
        // SET the size of the JFrame
        mainFrame.setSize(450,600);
        
        // SET the default close operation to exit on close
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
           
        // UPDATE mainFrame so that it is visible
        mainFrame.setVisible(true);
    
        // INITIALISE calculate to a new JButton called calculate
        calculate = new JButton("Calculate");
                      
        // INITIALISE addRow to a new JButton call add item
        addRow = new JButton("Add Item");
        
        // DECLARE a String array to hold the names of the columns of the table, call it columnNames
        String[] columnNames = {"Height", "Width"};

        // DECLARE a DefaultTableModel which will be used by the table
         model = new DefaultTableModel(0,0);
        
        // SET the columns of the model to the String array, columnNames
        model.setColumnIdentifiers(columnNames);
        
        // ADD a row to the DefaultTableModel of 0,0
        model.addRow(new Object[] {"0","0"});
             
        // INITIALISE exclusionTable to a new JTable
        exclusionTable = new JTable(model);
      
        // INITIALISE tablePane to a new instance of JScrollPane, passing exclusionTable
        tablePane = new JScrollPane(exclusionTable);
        
        JScrollPane outputPane = new JScrollPane(output);
        
        // DECLARE a new variable of type Dimension to hold the size of the pane
        Dimension size = new Dimension(100,100);
        
        // UPDATE the preferedSize of the tablePane by using setPreferedSize passing the size variable
        tablePane.setPreferredSize(size);
              
        // CALL mainCalcualte setupCalculate method, passing length, width and height JTextFields and exclusionTable
        mainCalculate.setupCalculate(length,width,height,coverage,output,exclusionTable);
        
        mainFrame.setLayout(new FlowLayout());
           
        // ADD all the components to the mainPanel. createRigidArea adds white space between the components
        mainPanel.add(lLabel);
        mainPanel.add(length);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(wLabel);
        mainPanel.add(width);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(hLabel);
        mainPanel.add(height);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(cLabel);
        mainPanel.add(coverage);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(excludedLabel);
        mainPanel.add(tablePane);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(addRow);
        mainPanel.add(calculate);
        
        // ADD the mainPanel to the mainFrame
        mainFrame.add(mainPanel);
        
        // ADD the outputPane to the mainFrame
        mainFrame.add(outputPane);
      
        // CALL the revalidate method on the mainPanel since sizes have been changed of components
        mainPanel.repaint();
        mainPanel.revalidate();
        
        // ADD an ActionListener to the calculate button of mainCalculate variable. will call the actionPerformed method
        // in that class
        calculate.addActionListener(mainCalculate);
               
        // ADD an action listener to the addRow button
        addRow.addActionListener(this);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // ADD a row to the DefaultTableModel of 0,0
        model.addRow(new Object[] {"0","0"});
    }

}
