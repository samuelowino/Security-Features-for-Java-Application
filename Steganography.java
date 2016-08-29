/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

/**
 *
 * @author samuel owino
 */

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

/**
 *
 * @author user
 */
public class Steganography extends JFrame {
    
    private static JMenuBar menuBar;
    private static JMenu fileMenuItem;
    private static JMenu optionsMenu;
    private static JMenu viewMenuItem;
    private static JTabbedPane tabbedPane;
    private static JMenuItem runNewEncryotionMenuItem;
    private static JMenuItem exitMenuItem;
    private static JMenuItem alwaysOnTopMenuItem;
    private static JMenuItem refreshNowMenuItem;
    private static JMenuItem updateBinnaryEncryptor;
    
    public Steganography(){
        
        setSize(710,660);
        setLocation(200,100);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuBar = new JMenuBar();
        fileMenuItem = new JMenu("File");
        optionsMenu = new JMenu("Options");
        viewMenuItem = new JMenu("View");
        tabbedPane = new JTabbedPane();
        runNewEncryotionMenuItem = new JMenuItem("Run new Encryption");
        exitMenuItem =  new JMenuItem("Exit");
        alwaysOnTopMenuItem = new JMenuItem("Always on top");
        refreshNowMenuItem = new JMenuItem("Refresh now");
        
        fileMenuItem.add(runNewEncryotionMenuItem);
        fileMenuItem.add(exitMenuItem);
        optionsMenu.add(alwaysOnTopMenuItem);
        viewMenuItem.add(refreshNowMenuItem);
        
        File file = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\"
                + "BinnaryEncryption\\src\\binnaryencryption\\crt.txt");
        File file2 = new File("C:\\Users\\user\\Documents\\Medical Distributed"
                + " System Development Budget1.docx");
        
        tabbedPane.addTab("Encode Message",new EncodeMessage());
        tabbedPane.addTab("Decode Message ", new DecodeMessage());
        tabbedPane.addTab("Create New Keys", new ChangeKeys());
        
        fileMenuItem.setBackground(Color.white);
        optionsMenu.setBackground(Color.white);
        viewMenuItem.setBackground(Color.white);
        tabbedPane.setBackground(Color.white);
        
        List<JLabel> statements = Arrays.asList(
        );
       
        exitMenuItem.addActionListener( e -> EncodeMessage.initiateExitProtocol());
        
        menuBar.add(fileMenuItem);
        menuBar.add(optionsMenu);
        menuBar.add(viewMenuItem);
        menuBar.add(Box.createHorizontalStrut(400));
        menuBar.setBackground(Color.white);
        setJMenuBar(menuBar);
        
        tabbedPane.setBounds(5,0,690,600);
        
        add(tabbedPane);
        
        repaint();
        setVisible(true);
    }
    
    public final void setTextProperties(List<JLabel> statementLabels) {
        statementLabels.stream()
                .forEach(e -> {
                    e.setForeground(Color.decode("#808080"));
                    e.setFont(new Font("Calibri Light", Font.PLAIN, 16));
                    add(e);

                });
    }
    
    public final void copyFiles(File origin,File destination){
        
    }
    
    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(
                new Runnable(){
                    @Override
                    public void run(){
                        new Steganography();
                    }
                }
        );
    }
}

