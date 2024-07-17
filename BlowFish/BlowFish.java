import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import java.util.Base64;

public class BlowFish {
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        Key secretKey = keyGenerator.generateKey();
        
        Cipher cipherOut = Cipher.getInstance("Blowfish/CFB/NoPadding");
        cipherOut.init(Cipher.ENCRYPT_MODE, secretKey);
        
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] iv = cipherOut.getIV();
        if (iv != null) {
            System.out.println("Initialization Vector of the Cipher: " + encoder.encodeToString(iv));
        }
        
        try (FileInputStream fin = new FileInputStream("inputFile.txt");
             FileOutputStream fout = new FileOutputStream("outputFile.txt");
             CipherOutputStream cout = new CipherOutputStream(fout, cipherOut)) {
             
            int input;
            while ((input = fin.read()) != -1) {
                cout.write(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//Output: Initialization Vector of the Cipher: 0x000102030405060708090A0B0C0D0E0F
// input.txt: Hello, World!
// output.txt: 諪\_�7�u���