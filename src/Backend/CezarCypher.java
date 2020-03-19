package Backend;

import java.util.stream.Collectors;

import static Backend.Constants.*;

public class CezarCypher {
    public static char magicCypher(int myLetter, int shift) {
        if (myLetter >= startUpperCase && myLetter <= endUpperCase) {
            return changeLetter(myLetter, shift, startUpperCase);
        } else if (myLetter >= startLowerCase && myLetter <= endLowerCase) {
            return changeLetter(myLetter, shift, startLowerCase);
        } else return (char) myLetter;
    }

    public static String textEncryption(String text, int shift) {
        return text.codePoints().mapToObj(letter -> {
            letter = magicCypher(letter, shift);
            return Character.toString((char) letter);
        }).collect(Collectors.joining());
    }

    static char changeLetter(int myLetter, int shift, int letterSizeShift) {
        myLetter -= letterSizeShift;
        myLetter += shift;
        myLetter = myLetter % (numberLettersInAlphabet + 1);
        myLetter += letterSizeShift;
        return (char) myLetter;
    }
}
