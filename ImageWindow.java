/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JDialog;

/**
 *
 * @author user
 */
public class ImageWindow extends JDialog {
    
    private static JLabel imageLabel;
    
    public ImageWindow(Image image){
        setSize(400,400);
        setLocation(0,0);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setModal(false);
        
        imageLabel = new JLabel("");
        
        imageLabel.setBounds(5,5,375,350);
        imageLabel.setBorder( new LineBorder(Color.decode("#1e90ff")));
        imageLabel.setBackground(Color.decode("#1e90ff"));
        
        imageLabel.setIcon( new ImageIcon(image));
        
        add(imageLabel);
        
        repaint();
        setVisible(true);
    }
}
