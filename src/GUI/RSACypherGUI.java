package GUI;

import cypher.CezarCypher;
import cypher.RSACypher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RSACypherGUI extends GUI {
    JFrame popUpCypherEffect;
    JLabel publicKeys;
    JLabel privateKeys;
    JLabel popUpEncryptedText;
    JLabel popUpDecryptedText;

    public RSACypherGUI() {
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

        popUpCypherEffect.add(publicKeys);
        popUpCypherEffect.add(privateKeys);
        popUpCypherEffect.add(popUpEncryptedText);
        popUpCypherEffect.add(popUpDecryptedText);
    }

    @Override
    protected void buttonAction() {
        //action listener submit
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg) {
                RSACypher cypher = new RSACypher();
                popUpCypherEffect.setVisible(true);
                publicKeys.setText("Public key: " + cypher.N + ", " + cypher.e);
                privateKeys.setText("Private key: " + cypher.N + ", " + cypher.d);
                String decryptedText = cypher.textEncryption(textField.getText());
                popUpEncryptedText.setText("<html>" + "Encrypted text: " + decryptedText + "</html>");
                popUpDecryptedText.setText("Decrypted text: " + cypher.textDecryption(cypher.textEncryption(textField.getText()), cypher.N, cypher.d));
                System.out.println(cypher.q);
                System.out.println(cypher.r);
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
