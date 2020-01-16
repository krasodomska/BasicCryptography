import java.util.stream.Collectors;

public class CezarCypher {
    public static char magicCypher(int myLetter, int shift) {
        if (myLetter > 64 && myLetter < 91) {
            return changeLetter(myLetter, shift, 65);
        } else if (myLetter > 96 && myLetter < 123) {
            return changeLetter(myLetter, shift, 97);
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
        myLetter = myLetter % 26;
        myLetter += letterSizeShift;
        return (char) myLetter;
    }
}
