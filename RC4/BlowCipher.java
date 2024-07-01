import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

public class BlowCipher {
    public static void main(String[] args) throws Exception {
        
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        
        SecretKey secretKey = keyGenerator.generateKey();

        Cipher cipher = Cipher.getInstance("Blowfish");

        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        String inputText = JOptionPane.showInputDialog("Input your message:");

        byte[] encrypted = cipher.doFinal(inputText.getBytes());

        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decrypted = cipher.doFinal(encrypted);

        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
            "\nEncrypted text: " + new String(encrypted) + "\n" +
            "\nDecrypted text: " + new String(decrypted));

        System.exit(0);
    }
}