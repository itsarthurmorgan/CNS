import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter a prime number: ");
        BigInteger p = sc.nextBigInteger(); // Here's one prime number
        
        System.out.print("Enter another prime number: ");
        BigInteger q = sc.nextBigInteger(); // ..and another.
        
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        
        BigInteger e = generateE(phi);
        BigInteger d = e.modInverse(phi); // Here's the multiplicative inverse
        
        System.out.println("Encryption keys are: (" + e + ", " + n + ")");
        System.out.println("Decryption keys are: (" + d + ", " + n + ")");
    }

    public static BigInteger generateE(BigInteger phi) {
        BigInteger e;
        BigInteger gcd;
        Random rand = new Random();
        
        do {
            int y = rand.nextInt(phi.intValue() - 1) + 1; // ensure y is not zero
            e = BigInteger.valueOf(y);
            gcd = phi.gcd(e);
        } while (e.compareTo(BigInteger.TWO) <= 0 || !gcd.equals(BigInteger.ONE));
        
        return e;
    }
}

// Output: Enter a prime number: 61
// Enter another prime number: 53
// Encryption keys are: (17, 3233)
// Decryption keys are: (2753, 3233)