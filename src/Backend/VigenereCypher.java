package Backend;

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
        List<String> myEncryptedText = new ArrayList<>();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char myLetter = text.charAt(i);
            if ((myLetter >= startUpperCase && myLetter <= endUpperCase) || (myLetter >= startLowerCase && myLetter <= endLowerCase)) {
                myEncryptedText.add(CezarCypher.textEncryption(Character.toString(myLetter), letterDifference(key.charAt(j % key.length()))));
                j++;
            } else {
                myEncryptedText.add(Character.toString(myLetter));
            }
        }
        return String.join("", myEncryptedText);
    }

    public static void main(String[] args) {
        System.out.println(
                textEncryption("AB CZ.", "ab")
        );
    }
}
