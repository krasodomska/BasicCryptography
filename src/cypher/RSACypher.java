package cypher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static utils.Constants.numberOfASCII;


public class RSACypher {
    List<Integer> primeNumber = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 71, 73, 79, 83, 89, 97);
    int q;
    int r;
    int N;
    int O;
    int e;
    int d;

    public RSACypher() {
        setQandR();
        setN();
        setE();
        setD();
    }

    private void setQandR() {
        while (q * r < numberOfASCII || q == r) {
            q = primeNumber.get((int) (Math.random() * primeNumber.size()));
            r = primeNumber.get((int) (Math.random() * primeNumber.size()));
        }
    }

    private void setE() {
        O = (q - 1) * (r - 1);
        for (int i = 2; i < O; i++) {
            if (N % i != 0 && O % i != 0) {
                e = i;
                break;
            }
        }
    }

    private void setD() {
        while (e*d % O != 1){
            d++;
        }
    }

    private void setN() {
        N = q * r;
    }

    private int mathMagic(int letter, int key, int keyN) {
        return new BigDecimal(letter).pow(key).remainder(new BigDecimal(keyN)).intValue();
    }

    public String textEncryption(String text) {
        List<Integer> encryptedText = new ArrayList<>();

        text.codePoints().forEach(letter ->
                encryptedText.add(
                        mathMagic(letter, e, N)
                )
        );
        return encryptedText.stream().map(Long::toString).collect(Collectors.joining(" "));
    }

    public String textDecryption(String text, int keyN, int keyD) {
        List<String> myEncryptedText = new ArrayList<>();
        List<Integer> encryptedText = new ArrayList<>(Arrays.asList(text.split(" "))).stream().map(Integer::parseInt).collect(Collectors.toList());
        encryptedText.forEach(letter ->
                myEncryptedText.add(Character.toString(
                        mathMagic(letter, keyD, keyN)
                        )
                )
        );
        return String.join("", myEncryptedText);
    }
}
