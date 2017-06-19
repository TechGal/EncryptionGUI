/**
 * Created by Aila on 2017-05-26.
 * Cryptography Application
 */

import javax.swing.*;
import java.awt.*;

public class Window {

    private JFrame frame;

    private JPanel window;
    private JPanel textSide;
    private JPanel cypherSide;
    private JPanel keyinfo;

    private JList cyphers;

    private JTextField key;
    private JTextArea enterText;
    private JTextArea returnText;

    private JCheckBox cesar;
    private JCheckBox vigenere;

    public static void main (String[] args) {
        Window app = new Window();
        app.window();
    }

    public void window () {
        frame = new JFrame();
        window = new JPanel(new FlowLayout());
        textSide = new JPanel(new BorderLayout());
        enterText = new JTextArea();
        returnText = new JTextArea();
        cypherSide = new JPanel(new GridLayout());
        cyphers = new JList();
        cesar = new JCheckBox();
        vigenere = new JCheckBox();
        keyinfo = new JPanel(new BorderLayout());

        frame.setTitle("Cryptography Application");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(window);
        frame.setVisible(true);

        window.setSize(800,500);
        window.add(textSide, FlowLayout.LEFT);
        window.add(cypherSide, FlowLayout.RIGHT);
        window.setVisible(true);

        textSide.setSize(400, 300);
        textSide.add(enterText, BorderLayout.NORTH);
        textSide.add(returnText, BorderLayout.SOUTH);
        textSide.setVisible(true);

        enterText.setSize(300, 100);
        enterText.setVisible(true);

        returnText.setSize(300, 100);
        returnText.setVisible(true);

        cypherSide.setSize(400, 300);
        cypherSide.add(cyphers);
        cypherSide.add(keyinfo);
        cypherSide.setVisible(true);

        cyphers.setSize(200, 100);
        cyphers.add(cesar);
        cyphers.add(vigenere);

        cesar.setActionCommand("cesar");
        cesar.setVisible(true);

        vigenere.setActionCommand("vigenere");
        vigenere.setVisible(true);
    }

}


