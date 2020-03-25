package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cypher.CezarCypher;

public class CezarCypherGUI extends GUI {
    @Override
    protected void setFrameName(){
        cypherName = "Cezar cypher";
    }

    @Override
    protected void buttonAction() {
        //action listener submit
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                cypherEffect.setText(CezarCypher.textEncryption(textField.getText(), Integer.parseInt(keyField.getText())));
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
