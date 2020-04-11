package cypher;

import java.util.ArrayList;
import java.util.List;
import static utils.Constants.*;

public class VigenereCypher {
    private static int letterDifference(char keyLetter) {
        if (Character.isUpperCase(keyLetter))
            return keyLetter - startUpperCase;
        else
            return keyLetter - startLowerCase;
    }

    public static String textEncryption(String text, String key) {
        List<String> myEncryptedText = new ArrayList<>();
        for (int i = 0, j = 0; i < text.length(); i++) {
            char myLetter = text.charAt(i);
            if (Character.isLetter(myLetter)) {
                myEncryptedText.add(
                        CezarCypher.textEncryption(
                                Character.toString(myLetter),
                                letterDifference(key.charAt(j % key.length()))
                        )
                );
                j++;
            } else {
                myEncryptedText.add(Character.toString(myLetter));
            }
        }
        return String.join("", myEncryptedText);
    }
}