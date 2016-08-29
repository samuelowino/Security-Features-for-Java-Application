/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JPanel;

/**
 *
 * @author user
 */
public class ChangeKeys extends JPanel {

    private static JLabel createNewKeyLabel;
    private static JLabel addSignImageLabel;
    private static JLabel statementOneLabel;
    private static JLabel statementTwoLabel;
    private static JLabel statementThreeLabel;
    private static JLabel oldKeyLabel;
    private static JLabel newKeyLabel;
    private static JTextField oldKeyField;
    private static JTextField newKeyField;
    private static JButton generateKeyButton;
    private static JButton submitButton;
    private static JButton cancelButton;
    private static JButton firstGreyLineButton;
    private static JButton secondGreyLineButton;
    private static String oldKey = "";

    public ChangeKeys() {

        setSize(600, 600);
        setLocation(100, 200);
        setLayout(null);
        setBackground(Color.white);

        createNewKeyLabel = new JLabel("Create New Key");
        addSignImageLabel = new JLabel(new ImageIcon("C:\\Users\\user\\Documents"
                + "\\NetBeansProjects\\BinnaryEncryption\\src\\binnaryencryption\\"
                + "plusSign.PNG"));
        statementOneLabel = new JLabel("The key you choose to use will be applied to other encrypted data,");
        statementTwoLabel = new JLabel("stored  even before the new keys are implementd.");
        statementThreeLabel = new JLabel("(The new keys supercede previouse set keys for all data.)");
        oldKeyLabel = new JLabel("Old Key");
        newKeyLabel = new JLabel("New Key");
        oldKeyField = new JTextField();
        newKeyField = new JTextField();
        generateKeyButton = new JButton("Generate");
        submitButton = new JButton("Submit");
        cancelButton = new JButton("Cancel");
        firstGreyLineButton = new JButton();
        secondGreyLineButton = new JButton();

        createNewKeyLabel.setForeground(Color.decode("#696969"));
        createNewKeyLabel.setBounds(40, 10, 200, 25);
        addSignImageLabel.setBounds(1, 10, 50, 25);
        statementOneLabel.setBounds(40, 50, 600, 25);
        statementTwoLabel.setBounds(40, 80, 600, 25);
        statementThreeLabel.setBounds(40, 100, 600, 25);
        oldKeyLabel.setBounds(100, 150, 100, 25);
        newKeyLabel.setBounds(100, 185, 100, 25);
        oldKeyField.setBounds(180, 150, 200, 25);
        generateKeyButton.setBounds(400, 150, 150, 30);
        newKeyField.setBounds(180, 185, 200, 25);
        submitButton.setBounds(250, 250, 100, 30);
        cancelButton.setBounds(360, 250, 100, 30);
        secondGreyLineButton.setBounds(40, 225, 520, 2);
        firstGreyLineButton.setBounds(40, 45, 520, 2);

        secondGreyLineButton.setBackground(Color.decode("#f5f5f5"));
        firstGreyLineButton.setBackground(Color.decode("#f5f5f5"));
        submitButton.setBackground(Color.decode("#1E90FF"));
        cancelButton.setBackground(Color.red);
        submitButton.setForeground(Color.white);
        cancelButton.setForeground(Color.white);
        submitButton.setBorder(new LineBorder(Color.decode("#1e90ff")));
        cancelButton.setBorder(new LineBorder(Color.red));
        generateKeyButton.setBorder(new LineBorder(Color.decode("#32cd32")));
        generateKeyButton.setBackground(Color.decode("#32cd32"));
        generateKeyButton.setForeground(Color.white);

        List<JTextField> textFields = Arrays.asList(
                oldKeyField, newKeyField
        );

        List<JLabel> statements = Arrays.asList(
                statementOneLabel, statementTwoLabel, statementThreeLabel, oldKeyLabel, newKeyLabel
        );

        setTextProperties(statements);
        setTextFieldProperties(textFields);

        oldKeyField.setText(getOldKey());

        submitButton.addActionListener(e -> {
            if (!newKeyField.getText().equals("")) {
                storeKeys(newKeyField.getText());
                getOldKey();
            } else if (newKeyField.getText().equals("")) {
                newKeyField.setBorder(new LineBorder(Color.red, 2));
                JOptionPane.showMessageDialog(this, "Cannot submit a blank key", "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);

            }

        });

        add(createNewKeyLabel);
        add(addSignImageLabel);
        add(firstGreyLineButton);
        add(secondGreyLineButton);
        add(submitButton);
        add(cancelButton);
        add(generateKeyButton);

        repaint();
        setVisible(true);
    }

    public final void setTextFieldProperties(List<JTextField> textFields) {
        textFields.stream()
                .forEach(e -> {

                    e.addFocusListener(
                            new FocusListener() {
                                @Override
                                public void focusGained(FocusEvent event) {
                                    e.setBorder(new LineBorder(Color.decode("#1E90FF"), 2));
                                }

                                @Override
                                public void focusLost(FocusEvent event) {
                                    e.setBorder(new LineBorder(Color.decode("#696969"), 2));

                                }

                            }
                    );
                    add(e);
                });
    }

    public final String getOldKey() {

        try {
            List<String> cipherTextLines = new ArrayList<>();

            BufferedReader in = new BufferedReader(new FileReader(new File("keyStore.txt")));
            String line;
            while ((line = in.readLine()) != null) {
                oldKey = line;  // collection of lines of plainText
                JOptionPane.showMessageDialog(this, "Old Key" + oldKey);
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Unable to Encrypt file" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
            return "";
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Unable to Encrypt file" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
            return "";
        }
        return oldKey;
    }

    public final void storeKeys(String key) {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(new File("keyStore.txt")));
            bufferedWriter.write(key);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Unable to Store key" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Unable to Store key" + ex.getMessage(), ""
                        + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public final void setTextProperties(List<JLabel> statements) {

        statements.stream()
                .forEach(e -> {
                    e.setForeground(Color.decode("#808080"));
                    e.setFont(new Font("Calibri Light", Font.BOLD, 14));
                    add(e);
                });
    }
}
