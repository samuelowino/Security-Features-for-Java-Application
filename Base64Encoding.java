/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androbot;

/**
 *
 * @author user
 */
import java.io.IOException;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;
import javax.swing.*;

public class Base64Encoding {

    private static byte[] inputData;

    public static void main(String[] args) {

        while (true) {
            String input = JOptionPane.showInputDialog(null, "Give me the data to encode");
            JOptionPane.showMessageDialog(null, "The Encoded Form is" + encode(input.getBytes()));

            JOptionPane.showMessageDialog(null, "The Decoded Form is" + decode(encode(input.getBytes())));
        }

    }

    public static byte[] encode(byte[] inputData) {
        String encodedData = new BASE64Encoder().encode(inputData);
        return encodedData.getBytes();
    }

    public static String decode(byte[] encodedData) {
        try {
             byte[] decodedData = new BASE64Decoder().decodeBuffer(encodedData.toString());
             return decodedData.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
       
    }
}
