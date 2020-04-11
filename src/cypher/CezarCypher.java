package cypher;

import java.util.stream.Collectors;
import static utils.Constants.*;

public class CezarCypher {
    private static char magicCypher(int myLetter, int shift) {
        if(Character.isUpperCase(myLetter)){
            return changeLetter(myLetter, shift, startUpperCase);
        } else if (Character.isLowerCase(myLetter)) {
            return changeLetter(myLetter, shift, startLowerCase);
        } else return (char) myLetter;
    }

    public static String textEncryption(String text, int shift) {
        return text.codePoints().mapToObj(letter -> {
            letter = magicCypher(letter, shift);
            return Character.toString((char) letter);
        }).collect(Collectors.joining());
    }

    private static char changeLetter(int myLetter, int shift, int letterSizeShift) {
        myLetter -= letterSizeShift;
        myLetter += shift;
        myLetter = myLetter % (numberLettersInAlphabet + 1);
        myLetter += letterSizeShift;
        return (char) myLetter;
    }
}
