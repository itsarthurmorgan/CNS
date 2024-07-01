import java.io.*;
import java.util.*;

public class SubstitutionCipher {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String b = "zyxwvutsrqponmlkjihgfedcba";
        
        System.out.print("Enter any string: ");
        String str = br.readLine();
        String decrypt = "";
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLowerCase(c)) {
                int j = a.indexOf(c);
                decrypt = decrypt + b.charAt(j);
            } else if (Character.isUpperCase(c)) {
                int j = a.indexOf(Character.toLowerCase(c));
                decrypt = decrypt + Character.toUpperCase(b.charAt(j));
            } else {
                decrypt = decrypt + c; // keep non-alphabetic characters unchanged
            }
        }
        
        System.out.println("The encrypted data is: " + decrypt);
    }
}