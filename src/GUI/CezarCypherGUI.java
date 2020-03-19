package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Backend.CezarCypher;

public class CezarCypherGUI extends GUI {
    protected void setFrameName(){
        cypherName = "Cezar cypher";
    }
    protected void buttonAction() {
        //action listener submit
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                cypherEffect.setText(CezarCypher.textEncryption(textField.getText(), Integer.parseInt(shiftField.getText())));
            }
        });

        fromButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg) {
                fileImported.setText("File imported");
            }
        });
    }

    public static void main(String[] args) {
        new CezarCypherGUI();
    }
}
