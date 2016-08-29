/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steganography;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class BinnaryEncryption {
 /**
     * @param args the command line arguments
     */
    public BinnaryEncryption(){
        
        
        
    }
    
    public static String generateBinnaryCipher(String cipher){
        
        try {
            //create digest
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            
            //digest message to get cipher
            byte[] binnaryCipherLevelOne = messageDigest.digest(cipher.getBytes());
            
            //further encrypt the data to level two cipher
            messageDigest.update(binnaryCipherLevelOne);
            
            //get StringBuilder'
            StringBuilder stringBuilder = new StringBuilder();
            
            for(int i = 0; i< binnaryCipherLevelOne.length;i++){
                stringBuilder.append(Integer.toString((binnaryCipherLevelOne[i] & 0xff) + 0x100,2)).toString();
            }
            
            return stringBuilder.toString();
            
        } catch (NoSuchAlgorithmException ex) {
            JOptionPane.showMessageDialog(null,"Unable toencrypt password\n An unexpected error occured....","Binnary Encryptor",JOptionPane.ERROR_MESSAGE);
            return "no value avaliable ";
        }
        
        
    }
}

