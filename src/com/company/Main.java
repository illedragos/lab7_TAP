package com.company;
/* Să se scrie o aplicaţie în care se afişează o fereastră ce conţine trei componente grafice:
JTextField pentru introducerea unui text, JTextField pentru afişare şi un buton JButton
pentru ieşirea din program. Atunci când se apasă tasta ENTER în primul JTextField,
textul introdus acolo va fi copiat în al doilea JTextField.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  extends JFrame implements ActionListener {

    // JTextField input
    static JTextField jTextFieldInput;

    // JFrame
    static JFrame jFrame;

    // JButton
    static JButton jButton;

    // JTextField output
    static JTextField jTextFieldOutput;

    public static void main(String[] args) {

        // create a new frame to store text fields and button
        jFrame = new JFrame("Laborator 7 TAP made by DragoShell");

        // create a textfield to display text
        jTextFieldOutput = new JTextField(50);
        jTextFieldOutput.setFont(new Font("SansSerif", Font.BOLD, 20));
        jTextFieldOutput.setBackground(Color.lightGray);

        // create a new button
        jButton = new JButton("EXIT");
        jButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        jButton.setBackground(Color.RED);

        // create a object of the text class
        Main program = new Main();

        // addActionListener to button
        jButton.addActionListener(program);

        // create a object of JTextField with 50 columns
        jTextFieldInput = new JTextField(50);
        jTextFieldInput.setFont(new Font("SansSerif", Font.BOLD, 20));
        jTextFieldInput.setBackground(Color.cyan);

        // create a panel to add buttons and textfields
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);

        // add buttons and textfields to panel
        p.add(jTextFieldInput);
        p.add(jTextFieldOutput);
        p.add(jButton);

        // add panel to frame
        jFrame.add(p);

        // set the size of frame
        jFrame.setSize(900, 400);

        jFrame.show();

        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // set the text of the jtextoutput to the text of the jtextinput
                jTextFieldOutput.setText(jTextFieldInput.getText());

                // set the text of field to blank
                jTextFieldInput.setText("  ");
            }
        };
        jTextFieldInput.addActionListener( action );

    }

    // if the button is pressed
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("EXIT")) {
            System.exit(0);
        }
    }

}
