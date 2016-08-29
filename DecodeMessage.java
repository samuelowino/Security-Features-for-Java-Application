/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author samuel owino
 */
public class DecodeMessage extends JPanel {

    private static JLabel firstStatementLabel;
    private static JLabel secondStatementLabel;
    private static JLabel thirdStatmentLabel;
    private static JFileChooser decryptViewSelectAFileChooser;
    private static JButton selectAFileButton;
    private static JPanel filePropertiesPanel;
    private static JLabel fileNameLabel;
    private static JLabel fileNameLabelValueLabel;
    private static JLabel fileExtension;
    private static JLabel fileExtensionValueLabel;
    private static JLabel sizeBeforeDecryptionLabel;
    private static JLabel sizeBeforeDecryptionValueLabel;
    private static JLabel sizeAfterDecryptionLabel;
    private static JLabel sizeAfterDecryptionValueLabel;
    private static JLabel locationLabel;
    private static JLabel locationValueLabel;
    private static JButton decryptButton;
    private static JButton cancelButton;
    private static JButton chooseADifferentFileButton;
    private static JLabel decryptViewChosenFileImageIcon;
    private static JLabel fileNameAndExtensionLabel;
    private static File chosenFile;

    public DecodeMessage() {

        setSize(600, 600);
        setLocation(0, 0);
        setBackground(Color.white);
        setLayout(null);
        setBorder(new LineBorder(Color.decode("#1e90ff")));

        firstStatementLabel = new JLabel("Alpha crypto: Helps you easily decrypt your ");
        secondStatementLabel = new JLabel("important encrypted files with no hustle.");
        thirdStatmentLabel = new JLabel("Get started by ");
        selectAFileButton = new JButton("selecting a file.");
        decryptViewSelectAFileChooser = new JFileChooser();
        filePropertiesPanel = new JPanel(null);
        fileNameLabel = new JLabel("File Name:");
        fileNameLabelValueLabel = new JLabel("");
        fileExtension = new JLabel("Extension:");
        fileExtensionValueLabel = new JLabel("");
        sizeBeforeDecryptionValueLabel = new JLabel("");
        sizeBeforeDecryptionLabel = new JLabel("Size before encryption:");
        sizeAfterDecryptionLabel = new JLabel("Size after encryption:");
        sizeAfterDecryptionValueLabel = new JLabel("");
        locationLabel = new JLabel("File Location:");
        locationValueLabel = new JLabel("\\file\\path\\name.extension");
        decryptButton = new JButton("Decrypt");
        cancelButton = new JButton("Exit");
        chooseADifferentFileButton = new JButton("Choose a different File");
        fileNameAndExtensionLabel = new JLabel("Choose a File");

        decryptViewChosenFileImageIcon = new JLabel(new ImageIcon("C:\\Users\\user"
                + "\\Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                + "binnaryencryption\\receiptsTrials.PNG"));

        List<JLabel> statements = Arrays.asList(
                firstStatementLabel, secondStatementLabel, thirdStatmentLabel,
                fileNameAndExtensionLabel
        );

        List<JLabel> inlineFilePropertiesStatement = Arrays.asList(
                fileNameLabel, sizeAfterDecryptionLabel, sizeBeforeDecryptionLabel, locationLabel, fileExtension
        );

        List<JLabel> inlineTextValueStatements = Arrays.asList(
                fileNameLabelValueLabel, fileExtensionValueLabel, sizeAfterDecryptionValueLabel,
                sizeBeforeDecryptionValueLabel, locationValueLabel
        );

        firstStatementLabel.setBounds(10, 5, 400, 25);
        secondStatementLabel.setBounds(10, 30, 400, 25);
        thirdStatmentLabel.setBounds(10, 60, 400, 25);
        selectAFileButton.setBounds(105, 60, 100, 25);
        filePropertiesPanel.setBounds(10, 90, 400, 300);
        decryptButton.setBounds(50, 400, 150, 35);
        cancelButton.setBounds(230, 400, 150, 35);
        chooseADifferentFileButton.setBounds(120, 460, 200, 35);
        decryptViewChosenFileImageIcon.setBounds(400, 150, 250, 120);
        fileNameAndExtensionLabel.setBounds(440, 270, 200, 25);
        fileNameLabel.setBounds(5, 10, 100, 25);
        fileNameLabelValueLabel.setBounds(80, 10, 300, 25);
        fileExtension.setBounds(5, 40, 200, 25);
        fileExtensionValueLabel.setBounds(80, 40, 300, 25);
        sizeBeforeDecryptionLabel.setBounds(5, 70, 200, 25);
        sizeBeforeDecryptionValueLabel.setBounds(160, 70, 200, 25);
        sizeAfterDecryptionLabel.setBounds(5, 100, 200, 25);
        sizeAfterDecryptionValueLabel.setBounds(145, 100, 200, 25);
        locationLabel.setBounds(5, 130, 200, 25);
        locationValueLabel.setBounds(100, 130, 300, 25);

        setTextProperties(statements);
        setInlineTextProperties(inlineFilePropertiesStatement);
        setInlineTextValuesProperties(inlineTextValueStatements);

        filePropertiesPanel.setBorder(new LineBorder(Color.decode("#696969")));
        filePropertiesPanel.setBackground(Color.white);
        decryptButton.setForeground(Color.white);
        decryptButton.setBorder(new LineBorder(Color.decode("#1e90ff")));
        cancelButton.setForeground(Color.white);
        cancelButton.setBorder(new LineBorder(Color.red));
        chooseADifferentFileButton.setForeground(Color.white);
        chooseADifferentFileButton.setBorder(new LineBorder(Color.decode("#32cd32")));
        cancelButton.setBackground(Color.red);
        chooseADifferentFileButton.setBackground(Color.decode("#32cd32"));
        decryptButton.setBackground(Color.decode("#1E90FF"));
        selectAFileButton.setBackground(Color.white);
        selectAFileButton.setBorder(new LineBorder(Color.white));
        selectAFileButton.setForeground(Color.decode("#1e90ff"));

        selectAFileButton.addActionListener(e -> {
            decryptViewSelectAFileChooser.showDialog(filePropertiesPanel, "Choose File To Decrypt");
            chosenFile = decryptViewSelectAFileChooser.getSelectedFile();
            try {

                if (chosenFile.getName().endsWith(".pdf")) {
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\"
                            + "user\\Documents\\NetBeansProjects\\BinnaryEncryption\\"
                            + "src\\binnaryencryption\\Screenshot (1803).png"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileExtensionValueLabel.setText(".pdf");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else if (chosenFile.getName().endsWith(".txt")) {
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\Documents"
                            + "\\NetBeansProjects\\BinnaryDecryption\\src\\binnaryencryption\\Screenshot (1806) - Copy.png"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileExtensionValueLabel.setText(".txt");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else if (chosenFile.getName().endsWith(".mp4") || chosenFile.getName().endsWith(".mkv")
                        || chosenFile.getName().endsWith(".mp3")) {
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryDecryption\\src\\"
                            + "binnaryencryption\\Screenshot (1804) - Copy.png"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileExtensionValueLabel.setText(".mp4");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else if (chosenFile.getName().endsWith(".docx") || chosenFile.getName().endsWith(".doc")) {
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryDecryption\\src\\"
                            + "binnaryencryption\\Screenshot (1807) - Copy.png"));
                    fileExtensionValueLabel.setText(".docx");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else if (chosenFile.getName().endsWith(".docx") || chosenFile.getName().endsWith(".doc")) {
                    /* JOptionPane.showMessageDialog(null, "Unknown File Extension type",
                    "Windows Cryptomax", JOptionPane.ERROR_MESSAGE);
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                    + "Documents\\NetBeansProjects\\BinnaryDecryption\\src\\"
                    + "binnaryencryption\\receiptsTrials - Copy.PNG"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileNameAndExtensionLabel.setText("unknown File");
                    fileExtensionValueLabel.setText("unknown");*/

                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryEncryption\\src\\"
                            + "binnaryencryption\\Screenshot (1807).png"));
                    fileExtensionValueLabel.setText(".docx");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                }

                locationValueLabel.setText(chosenFile.getPath());
                fileNameLabelValueLabel.setText(chosenFile.getName());
                sizeBeforeDecryptionValueLabel.setText("" + chosenFile.getTotalSpace());

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No File has been selected.",
                        "Binnary Decryptor", JOptionPane.WARNING_MESSAGE);
            }

        });

        decryptButton.addActionListener(e -> {
            try {

                String backUpFile = JOptionPane.showInputDialog(null, "Enter your key..");
                readBackUpFile(new File(backUpFile + ".txt"));
                writeDecryptedContentToFile(chosenFile, readBackUpFile(new File(backUpFile + ".txt")));
                JOptionPane.showMessageDialog(null, "File Decryption in progress...", ""
                        + "Binnary Decryptor", JOptionPane.INFORMATION_MESSAGE);

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No File has been selected.", ""
                        + "Binnary Decryptor", JOptionPane.WARNING_MESSAGE);
            }

        });

        chooseADifferentFileButton.addActionListener((ActionEvent e) -> {
            decryptViewSelectAFileChooser.showDialog(filePropertiesPanel, "Choose File To Decrypt");
            chosenFile = decryptViewSelectAFileChooser.getSelectedFile();
            try {

                if (chosenFile.getName().endsWith(".pdf")) {
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\Documents"
                            + "\\NetBeansProjects\\BinnaryDecryption\\src\\binnaryencryption\\Screenshot (1803) - Copy.png"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileExtensionValueLabel.setText(".pdf");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else if (chosenFile.getName().endsWith(".txt")) {
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\Documents"
                            + "\\NetBeansProjects\\BinnaryDecryption\\src\\binnaryencryption\\Screenshot (1806) - Copy.png"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileExtensionValueLabel.setText(".txt");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else if (chosenFile.getName().endsWith(".mp4") || chosenFile.getName().endsWith(".mkv")
                        || chosenFile.getName().endsWith(".mp3")) {
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryDecryption\\src\\"
                            + "binnaryencryption\\Screenshot (1804) - Copy.png"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileExtensionValueLabel.setText(".mp4");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else if (chosenFile.getName().endsWith(".docx") || chosenFile.getName().endsWith(".doc")) {
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryDecryption\\src\\"
                            + "binnaryencryption\\Screenshot (1807).png"));
                    fileExtensionValueLabel.setText(".docx");
                    fileNameAndExtensionLabel.setText(chosenFile.getName());
                } else {
                    JOptionPane.showMessageDialog(null, "Unknown File Extension type", "Windows Cryptomax", JOptionPane.ERROR_MESSAGE);
                    decryptViewChosenFileImageIcon.setIcon(new ImageIcon("C:\\Users\\user\\"
                            + "Documents\\NetBeansProjects\\BinnaryDecryption\\src\\"
                            + "binnaryencryption\\receiptsTrials - Copy.PNG"));
                    JOptionPane.showMessageDialog(null, "" + chosenFile.getPath());
                    fileNameAndExtensionLabel.setText("unknown File");
                    fileExtensionValueLabel.setText("unknown");
                }

                locationValueLabel.setText(chosenFile.getPath());
                fileNameLabelValueLabel.setText(chosenFile.getName());
                sizeBeforeDecryptionValueLabel.setText("" + chosenFile.getTotalSpace());

            } catch (NullPointerException ex) {
                JOptionPane.showMessageDialog(null, "No File has been selected.",
                        "Binnary Decryptor", JOptionPane.WARNING_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> initiateExitProtocol());

        add(decryptViewChosenFileImageIcon);
        add(filePropertiesPanel);
        add(decryptButton);
        add(cancelButton);
        add(chooseADifferentFileButton);
        add(selectAFileButton);

        add(fileNameAndExtensionLabel);

        repaint();
        setVisible(true);

    }

    public final List<String> readBackUpFile(File backUpFile) {
        //read file using path
        List<String> plainTextLines = new ArrayList<>();
        try {
            List<String> cipherTextLines = new ArrayList<>();

            BufferedReader in = new BufferedReader(new FileReader(backUpFile));
            String line;
            while ((line = in.readLine()) != null) {
                plainTextLines.add(line);  // collection of lines of plainText
            }
            plainTextLines.stream()
                    .forEach(e -> {
                        System.out.println(e);
                    });
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
        }
        return plainTextLines;
    }

    /**
     * Write the binary digits to the plain file file
     *
     * @param binnaryDigits
     */
    public final void writeDecryptedContentToFile(File fileToBeDecrypted, List<String> linesOfPlainText) {
        try {
            //setCursor(new Cursor(Cursor.WAIT_CURSOR));
            FileWriter writer = new FileWriter(fileToBeDecrypted);

            BufferedWriter b_writer = new BufferedWriter(writer);

            linesOfPlainText.stream()
                    .forEach(e -> {
                        try {
                            b_writer.write(e);
                            b_writer.newLine();
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(filePropertiesPanel, "Unable to Encrypt file" + ex.getMessage(), ""
                                    + "Binnary Encryptor", JOptionPane.ERROR_MESSAGE);
                        }
                    });
            b_writer.flush();

            b_writer.close();
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Encryption failed" + ex.getMessage(), ""
                    + "Try again later", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Encryption failed" + ex.getMessage(), ""
                    + "Try again later", JOptionPane.WARNING_MESSAGE);
        }
    }

    public final void setTextProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.decode("#808080"));
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    add(e);

                });
    }

    public final void setInlineTextProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.decode("#808080"));
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    filePropertiesPanel.add(e);

                });
    }

    public final void setInlineTextValuesProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.black);
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    filePropertiesPanel.add(e);

                });
    }

    public static void initiateExitProtocol() {
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want "
                + "to exit?", "Binnary Decryptor", JOptionPane.INFORMATION_MESSAGE);
        switch (option) {
            case JOptionPane.NO_OPTION:
                //do nothing
                break;
            case JOptionPane.CANCEL_OPTION:
                //do nothing
                break;
            case JOptionPane.YES_OPTION:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(filePropertiesPanel, "An unexpected "
                        + "error occured.", "Binnary Decryptor", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }

}
