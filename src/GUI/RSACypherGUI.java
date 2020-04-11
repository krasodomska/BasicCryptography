package GUI;

import cypher.RSACypher;
import utils.FileHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RSACypherGUI extends GUI {
    private JFrame popUpCypherEffect;       // privates
    private JLabel publicKeys;
    private JLabel privateKeys;
    private JLabel popUpEncryptedText;
    private JLabel popUpDecryptedText;

    private RSACypherGUI() {
        //base frame settings
        keyField.setText("For this cypher it's unnecessary");
        setFrameName();

        //label settings
        publicKeys = new JLabel();
        publicKeys.setBounds(10, 0, 300, 100);

        privateKeys = new JLabel();
        privateKeys.setBounds(10, 20, 200, 100);

        popUpEncryptedText = new JLabel();
        popUpEncryptedText.setBounds(10, 50, 200, 100);

        popUpDecryptedText = new JLabel();
        popUpDecryptedText.setBounds(10, 100, 300, 100);

        //popup settings
        popUpCypherEffect = new JFrame(cypherName);
        popUpCypherEffect.setSize(300, 350);
        popUpCypherEffect.setLayout(null);
        popUpCypherEffect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //add labels
        popUpCypherEffect.add(publicKeys);
        popUpCypherEffect.add(privateKeys);
        popUpCypherEffect.add(popUpEncryptedText);
        popUpCypherEffect.add(popUpDecryptedText);
    }

    @Override
    protected void submitAction() {

        submitButton.addActionListener(arg -> {
            RSACypher cypher = new RSACypher();
            popUpCypherEffect.setVisible(true);
            publicKeys.setText("Public key: " + cypher.N + ", " + cypher.e);
            privateKeys.setText("Private key: " + cypher.N + ", " + cypher.d);
            String decryptedText = cypher.textEncryption(textField.getText());
            popUpEncryptedText.setText("<html>" + "Encrypted text: " + decryptedText + "</html>");
            popUpDecryptedText.setText("Decrypted text: " + cypher.textDecryption(cypher.textEncryption(textField.getText()), cypher.N, cypher.d));

            cyphredText = "Public key: " + cypher.N + ", " + cypher.e + "\n" + "Private key: " + cypher.N + ", " + cypher.d + "\n" + "Encrypted text: " + decryptedText + "\n" + "Decrypted text: " + cypher.textDecryption(cypher.textEncryption(textField.getText()), cypher.N, cypher.d);
        });
    }

    @Override
    protected void addFileAction() {
        fromButton.addActionListener(arg -> {
            RSACypher cypher = new RSACypher();
            popUpCypherEffect.setVisible(true);
            publicKeys.setText("Public key: " + cypher.N + ", " + cypher.e);
            privateKeys.setText("Private key: " + cypher.N + ", " + cypher.d);
            String decryptedText = null;
            try {
                decryptedText = cypher.textEncryption(FileHandler.fileContent());
            } catch (IOException e) {
                e.printStackTrace();
            }
            popUpEncryptedText.setText("<html>" + "Encrypted text: " + decryptedText + "</html>");
            popUpDecryptedText.setText("Decrypted text: " + cypher.textDecryption(decryptedText, cypher.N, cypher.d));

            cyphredText = "Public key: " + cypher.N + ", " + cypher.e + "\n" + "Private key: " + cypher.N + ", " + cypher.d + "\n" + "Encrypted text: " + decryptedText + "\n" + "Decrypted text: " + cypher.textDecryption(cypher.textEncryption(textField.getText()), cypher.N, cypher.d);
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
