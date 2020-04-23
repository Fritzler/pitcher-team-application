/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballgui;

import java.awt.*;
import javax.swing.*;

public class BaseballPitcherGUI extends JFrame {
    
    //Components of the form.
    //Text fields.
    private JTextField nameField;
    private JTextField ageField;
    private JTextField numberField;
    
    //Radio Buttons
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    
    
    public BaseballPitcherGUI() {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }
    
    private void initComponents() {
        setTitle("Baseball Pitcher Stats");
        setLayout(new BorderLayout());
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        /*Name, Age, and Gender entries Start Area*/
        nameField = new JTextField();
        ageField = new JTextField();
        numberField = new JTextField();
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");
        
        //Setting the minimum and prefered dimensions for all four fields.
        Dimension dim = new Dimension(150, 20);
        //Prefered
        nameField.setPreferredSize(dim);
        ageField.setPreferredSize(dim);
        numberField.setPreferredSize(dim);
        //Minimum
        nameField.setMinimumSize(dim);
        ageField.setMinimumSize(dim);
        numberField.setPreferredSize(dim);
        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);
        /*Name, Age, and Gender entries End Area*/
        
        
        //Create a panel using GridBagLayout
        JPanel basicInfoPanel = new JPanel();
        basicInfoPanel.setBorder(BorderFactory.createTitledBorder("Basic Information"));
        basicInfoPanel.setLayout(new GridBagLayout());
            //Player Name
            basicInfoPanel.add(new JLabel("Player Name:"), getConstraints(0,0));
            basicInfoPanel.add(nameField, getConstraints(1,0));
            //Player Age
            basicInfoPanel.add(new JLabel("Player Age:"), getConstraints(0,1));
            basicInfoPanel.add(ageField, getConstraints(1,1));
            //Player Number
            basicInfoPanel.add(new JLabel("Player Number:"), getConstraints(0,2));
            basicInfoPanel.add(numberField, getConstraints(1,2));
        
        //Adding the panel for the gender. Only two buttons.
        JPanel genderPanel = new JPanel();
        genderPanel.setBorder(BorderFactory.createTitledBorder("Gender"));
        genderPanel.setLayout(new FlowLayout());
        genderPanel.add(maleRadioButton);
        genderPanel.add(femaleRadioButton);    
        
            
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(basicInfoPanel);
        panel.add(genderPanel);
        
        add(panel, BorderLayout.CENTER);
        
        setSize(270, 280);
    }
    
    // helper method for getting a GridBagConstraints object
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            BaseballPitcherGUI frame = new BaseballPitcherGUI();
            frame.setVisible(true);
        });
    }
}
