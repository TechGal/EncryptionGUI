import java.util.Scanner;

/**
 * Created by Aila on 2017-06-02.
 * Vigenere Cypher
 */
public class Vigenere {

    static Scanner input = new Scanner(System.in);

    static String msg = "";
    static String key = "";

    public static void main (String[] args) {

        System.out.println("Welcome to the Vigenere Cypher");
        System.out.println("Enter your message: ");
        String msg = input.nextLine();
        System.out.println("Enter your key word: ");
        String key = input.next();

        String m = msg.toUpperCase();
        String k = key.toUpperCase();

        System.out.println("Your message is (" + m + ") and your key is (" + key + ").");

        String emsg = encrypt(m, k);
        String gmsg = decrypt(m, k);

        System.out.println("Encrypted, your message is " + emsg + ".");
        System.out.println("Unencrypted, your message is " + gmsg + ".");

    }

    public static String encrypt (String msg, String key) {
        int m = msg.length();
        int k = key.length();
        int rep = m/k;
        int spaces = 0;

        String bigkey = "";
        String emsg = "";

        for (int x=0; x<rep+1; x++) {
            bigkey = bigkey + key;
        }

        for (int y=0; y<m; y++) {
            String a = String.valueOf(msg.charAt(y));
            if (a.equals(" ")) {
                emsg = emsg + " ";
                spaces++;
            }
            else {
                int b = txtToNum(a);
                int l = txtToNum(String.valueOf(bigkey.charAt(y-spaces)));
                int c = b + l;
                if (c > 26) {
                    c = c - 26;
                }
                String d = numToTxt(c);
                emsg = emsg + d;
            }
        }

        return emsg;
    }

    public static String decrypt (String emsg, String key) {
        int m = emsg.length();
        int k = key.length();
        int rep = m/k;
        int spaces = 0;

        String bigkey = "";
        String gmsg = "";

        for (int x=0; x<rep+1; x++) {
            bigkey = bigkey + key;
        }

        for (int y=0; y<m; y++) {
            String a = String.valueOf(emsg.charAt(y));
            if (a.equals(" ")) {
                gmsg = gmsg + " ";
                spaces++;
            }
            else {
                int b = txtToNum(a);
                int l = txtToNum(String.valueOf(bigkey.charAt(y-spaces)));
                int c = b - l - (26-l);
                if (c < 0) {
                    c = c + 26;
                }
                String d = numToTxt(c);
                gmsg = gmsg + d;
            }
        }

        return gmsg;
    }

    public static int txtToNum (String let) {
        int a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(let) + 1;
        return a;
    }

    public static String numToTxt (int num) {
        String a = String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(num - 1));
        return a;
    }

}
