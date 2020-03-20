package GUI;

import Backend.CezarCypher;
import Backend.VigenereCypher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VigenereCypherGUI extends GUI {

    @Override
    protected void buttonAction() {
        //action listener submit
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                cypherEffect.setText(VigenereCypher.textEncryption(textField.getText(),shiftField.getText()));
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
        cypherName = "Vigenere cypher";
    }

    public static void main(String[] args) {
        new VigenereCypherGUI();
    }
}
