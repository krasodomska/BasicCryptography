package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public abstract class GUI{
    JFrame frame;
    JButton submitButton;
    JButton fromButton;
    JButton toButton;
    JLabel labelTextToCypher;
    JLabel labelShift;
    JTextField textField;
    JTextField shiftField;
    JLabel cypherEffect;
    JLabel fileImported;
    String cypherName;


    GUI() {
        setFrameName();
        frame = new JFrame(cypherName);
        //submit button
        submitButton = new JButton("Submit");
        submitButton.setBounds(150, 200, 120, 40);
        //from file button
        fromButton = new JButton("From file");
        fromButton.setBounds(10, 150, 120, 40);
        //to file button
        toButton = new JButton("Create file");
        toButton.setBounds(150, 150, 120, 40);
        //enter text label
        labelTextToCypher = new JLabel();
        labelTextToCypher.setText("Enter text :");
        labelTextToCypher.setBounds(10, 10, 100, 100);
        //enter shift label
        labelShift = new JLabel();
        labelShift.setText("Enter key:");
        labelShift.setBounds(10, 60, 100, 100);
        //textField to enter text
        textField = new JTextField();
        textField.setBounds(110, 50, 130, 30);
        //textField to enter text
        shiftField = new JTextField();
        shiftField.setBounds(110, 100, 130, 30);

        //empty label which will show event after button clicked
        cypherEffect = new JLabel();
        cypherEffect.setBounds(10, 210, 200, 100);

        //empty label which will info
        fileImported = new JLabel();
        fileImported.setBounds(10, 200, 120, 40);

        //add to frame
        frame.add(cypherEffect);
        frame.add(textField);
        frame.add(labelTextToCypher);
        frame.add(labelShift);
        frame.add(shiftField);
        frame.add(fromButton);
        frame.add(toButton);
        frame.add(submitButton);
        frame.add(fileImported);


        //frame settings
        frame.setSize(300, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buttonAction();
    }

    protected abstract void buttonAction();
    protected abstract void setFrameName();
//        //action listener submit
//        submitButton.addActionListener(new ActionListener() {
//
//            @Override
//            public void actionPerformed(ActionEvent arg) {
//                cypherEffect.setText(Backend.CezarCypher.textEncryption(textField.getText(), Integer.parseInt(shiftField.getText())));
//            }
//        });
//
//        fromButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent arg) {
//                fileImported.setText("File imported");
//            }
//        });

}