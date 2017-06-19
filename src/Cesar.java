import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JOptionPane;

/**
 * Created by Aila on 2017-05-26.
 * Cesar Cypher
 */


public class Cesar {

    static Scanner input = new Scanner(System.in);

    static String msg = "";
    static String key = "";

    static String emsg = "";

    public static void main (String[] args) {

        Cesar cesar = new Cesar();
        cesar.window();
    } //main

    public static void submitted (String key, String msg) {
        String m = msg.toUpperCase();
        String k = key.toUpperCase();

        emsg = encrypt(msg, key);
    }

    public static String encrypt (String msg, String key) {
        key = key.substring(0,1);
        int k = txtToNum(key);
        String emsg = "";

        for (int x=0; x<msg.length(); x++) {
            String a = String.valueOf(msg.charAt(x));
            if (a.equals(" ")) {
                emsg = emsg + " ";
            }
            else {
                int b = txtToNum(a);
                int c = b + k;
                if (c > 26) {
                    c = c-26;
                }
                String d = numToTxt(c);
                emsg = emsg + d;
            }
        }

        return emsg;
    }

    public static String decrypt (String emsg, String key) {
        int k = txtToNum(key);
        String msg = "";

        for (int x=0; x<emsg.length(); x++) {
            String a = String.valueOf(emsg.charAt(x));
            if (a.equals(" ")) {
                msg = msg + " ";
            }
            else {
                int b = txtToNum(a);
                int c = b - k - (26-k);
                if (c < 0) {
                    c = c + 26;
                }
                String d = numToTxt(c);
                msg = msg + d;
            }
        }

        return msg;
    }

    public static int txtToNum (String let) {
        int a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(let) + 1;
        return a;
    }

    public static String numToTxt (int num) {
        String a = String.valueOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(num - 1));
        return a;
    }

    public void window () {
        final JFrame[] window = {new JFrame()};
        JPanel panel = new JPanel(new FlowLayout());
        JTextField key = new JTextField(10);
        JLabel keyLabel = new JLabel("Enter your key (one letter): ");
        JTextField entertxt = new JTextField(20);
        JLabel entertxtLabel = new JLabel("Enter your message: ");
        JButton encrypttxt = new JButton("Encrypt");
        JButton decrypttxt = new JButton("Decrypttxt");
        JPanel labels = new JPanel();

        JLabel original = new JLabel("               ");
        JLabel encrypted = new JLabel("Encrypted Text");

        window[0].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window[0].setTitle("Cesar Cypher");
        window[0].setLayout(new FlowLayout());
        window[0].setSize(300, 300);
        window[0].add(entertxtLabel);
        window[0].add(entertxt);
        window[0].add(keyLabel);
        window[0].add(key);
        window[0].add(encrypttxt);
        window[0].add(decrypttxt);
        window[0].add(labels);
        window[0].setVisible(true);

        entertxtLabel.setVisible(true);

        entertxt.setSize(200, 50);
        entertxt.setVisible(true);

        keyLabel.setVisible(true);

        key.setSize(200, 50);
        key.setVisible(true);

        encrypttxt.setActionCommand("encrypt");
        encrypttxt.setText("Encrypt");
        encrypttxt.setAction(null);
        encrypttxt.setSize(100, 50);
        encrypttxt.setVisible(true);

        decrypttxt.setActionCommand("decrypt");
        decrypttxt.setText("Decrypt");
        decrypttxt.setAction(null);
        decrypttxt.setSize(100, 50);
        decrypttxt.setVisible(true);

        labels.setLayout(new BoxLayout(labels, BoxLayout.Y_AXIS));
        labels.add(original);
        labels.add(encrypted);
        labels.setVisible(true);

        original.setSize(200, 50);
        original.setVisible(true);

        encrypted.setSize(200, 50);
        encrypted.setVisible(true);

        encrypttxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message is: " + entertxt.getText() + ", key is: " + key.getText());

                encrypted.setText(encrypt(entertxt.getText().toUpperCase(), key.getText().toUpperCase()));
                encrypted.setVisible(true);
            }
        });

        decrypttxt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Message is: " + entertxt.getText() + ", key is: " + key.getText());
                System.out.println("Decrypted is: " + decrypt(entertxt.getText().toUpperCase(), key.getText().toUpperCase()));

                encrypted.setText(decrypt(entertxt.getText().toUpperCase(), key.getText().toUpperCase()));
                encrypted.setVisible(true);
            }
        });
    }
} //cesar
