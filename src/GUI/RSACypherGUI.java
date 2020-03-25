package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RSACypherGUI extends GUI {
    JFrame popUpCypherEffect;

    public RSACypherGUI() {
        //base frame settings
        keyField.setText("For this cypher it's unnecessary");
        setFrameName();

        //popup settings
        popUpCypherEffect = new JFrame(cypherName);


        popUpCypherEffect.setSize(300, 350);
        popUpCypherEffect.setLayout(null);
        popUpCypherEffect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    protected void buttonAction() {
        //action listener submit
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                popUpCypherEffect.setVisible(true);
            }
        });

        fromButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg) {
                fileImported.setText("File imported");
            }
        });
    }

    @Override
    protected void setFrameName() {
        cypherName = "RSA cypher";
    }

    public static void main(String[] args) {
        new RSACypherGUI();
    }

}
