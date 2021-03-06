package GUI;

import utils.FileHandler;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GUI{
    private JFrame frame;
    JButton submitButton;
    JButton fromButton;
    private JButton toButton;
    private JLabel labelTextToCypher;
    private JLabel labelKey;
    JTextField textField;
    JTextField keyField;
    JLabel cypherEffect;
    private JLabel fileImported;
    String cypherName;
    String cyphredText;

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
        labelKey = new JLabel();
        labelKey.setText("Enter key:");
        labelKey.setBounds(10, 60, 100, 100);

        //textField to enter text
        textField = new JTextField();
        textField.setBounds(110, 50, 130, 30);

        //textField to enter text
        keyField = new JTextField();
        keyField.setBounds(110, 100, 130, 30);

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
        frame.add(labelKey);
        frame.add(keyField);
        frame.add(fromButton);
        frame.add(toButton);
        frame.add(submitButton);
        frame.add(fileImported);


        //frame settings
        frame.setSize(300, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        submitAction();
        addFileAction();
        createFileAction();
    }

    private void createFileAction(){                      // private + lambda
        toButton.addActionListener(arg -> {
            if (cyphredText != null) {
                FileHandler.createFilledFile(cyphredText);
                cypherEffect.setText("File created");
            } else fileImported.setText("Import file or submit text");
        });
    }

    protected abstract void addFileAction();
    protected abstract void submitAction();
    protected abstract void setFrameName();

}