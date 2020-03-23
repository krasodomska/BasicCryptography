package cypher;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.Constants.numberOfASCII;


public class RSACypher {
    static List<Integer> primeNumber = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 71, 73, 79, 83, 89, 97);
    static int q;
    static int r;
    static int N;
    static int O;
    static int J;
    static int T;

    private static void setQandR(){
        while (q*r < numberOfASCII || q==r) {
            q = primeNumber.get((int) (Math.random() * primeNumber.size()));
            r = primeNumber.get((int) (Math.random() * primeNumber.size()));
        }
    }

    private static void setKeys(int q, int r) {
        RSACypher.q = q;
        RSACypher.r = r;
        setQandR();
        N = q * r;
        O = (q - 1) * (r - 1);
        J = 5;
        T = 17;

    }

    public static String textEncryption(String text) {
        setKeys(3, 43);
        List<String> myEncryptedText = new ArrayList<>();
        List<Long> encryptedText = new ArrayList<>();

        text.codePoints().forEach(letter ->
                encryptedText.add(
                        (new BigDecimal(letter).pow(J).remainder(new BigDecimal(N))).longValue()
                )
        );

        encryptedText.forEach(letter ->
                myEncryptedText.add(Character.toString(
                        new BigDecimal(letter).pow(T).remainder(new BigDecimal(N)).intValue()
                        )
                )
        );

        return String.join("", myEncryptedText);
    }

    public static void main(String[] args) {
        textEncryption("ANNA}0");
    }
}
