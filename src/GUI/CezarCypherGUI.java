package GUI;

import cypher.CezarCypher;
import utils.FileHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CezarCypherGUI extends GUI {

    @Override
    protected void setFrameName() {
        cypherName = "Cezar cypher";
    }

    @Override
    protected void submitAction() {
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                String key = keyField.getText();
                Pattern patternOnlyDigit = Pattern.compile("^[0-9]*$");
                Matcher m = patternOnlyDigit.matcher(key);
                if (m.find() && key.length() > 0) {
                    cyphredText = CezarCypher.textEncryption(textField.getText(), Integer.parseInt(keyField.getText()));

                } else {
                    cyphredText = "Key should be digit";
                }
                cypherEffect.setText(cyphredText);
            }
        });
    }

    @Override
    protected void addFileAction() {
        fromButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg) {
                String key = keyField.getText();
                Pattern patternOnlyDigit = Pattern.compile("^[0-9]*$");
                Matcher m = patternOnlyDigit.matcher(key);
                try {
                    if (m.find() && key.length() > 0) {
                        cyphredText = CezarCypher.textEncryption(FileHandler.fileContent(), Integer.parseInt(key));

                    } else {
                        cyphredText = "Key should be digit";
                    }
                    cypherEffect.setText(cyphredText);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cypherEffect.setText(cyphredText);
            }
        });
    }

    public static void main(String[] args) {
        new CezarCypherGUI();
    }
}
