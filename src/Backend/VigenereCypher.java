package Backend;

import GUI.CezarCypherGUI;

import java.util.ArrayList;
import java.util.List;

import static Backend.Constants.*;

public class VigenereCypher {
    private static int letterDifference(char keyLetter) {
        if (keyLetter >= startUpperCase && keyLetter <= endUpperCase)
            return keyLetter - startUpperCase;
        else
            return keyLetter - startLowerCase;
    }

    public static String textEncryption(String text, String key) {
        text = prepareText(text);
        key = prepareKey(key, text.length());
        List<String> myEncryptedText = new ArrayList<>();
        for(int i = 0; i< text.length(); i++){
            myEncryptedText.add(CezarCypher.textEncryption(Character.toString(text.charAt(i)), letterDifference(key.charAt(i))));
        }
        return String.join("", myEncryptedText);
    }

    private static String prepareText(String text) {
        return text;
    }

    private static String prepareKey(String key, int length) {
        return key;
    }

    public static void main(String[] args) {
        System.out.println(
        textEncryption("ABCZ", "aaaa")
        );
    }
}
