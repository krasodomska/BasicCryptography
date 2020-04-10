package GUI;

import cypher.VigenereCypher;
import utils.FileHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VigenereCypherGUI extends GUI {

    @Override
    protected void submitAction() {
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                String key = keyField.getText();
                Pattern patternOnlyDigit = Pattern.compile("^[a-z]*$");
                Matcher m = patternOnlyDigit.matcher(key);
                if (m.find() && key.length() > 0) {
                    cyphredText = VigenereCypher.textEncryption(textField.getText(), keyField.getText());
                } else {
                    cyphredText = "Key should be letter";
                }
                cypherEffect.setText(cyphredText);
            }
        });
    }

    protected void addFileAction() {
        fromButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg) {
                String key = keyField.getText().toLowerCase();
                Pattern patternOnlyDigit = Pattern.compile("^[a-z]*$");
                Matcher m = patternOnlyDigit.matcher(key);
                try {
                    if (m.find() && key.length() > 0) {
                        cyphredText = VigenereCypher.textEncryption(FileHandler.fileContent(), key);

                    } else {
                        cyphredText = "Key should be letter";
                    }
                    cypherEffect.setText(cyphredText);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                cypherEffect.setText(cyphredText);
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
