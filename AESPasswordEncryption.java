/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package androbot;

/**
 *
 * @author samuel owino
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESPasswordEncryption {

    private static SecretKeySpec secreteKey;
    private static byte[] key;

    private static String decryptedString;
    private static String encryptedString;

    public static String getDecryptedString() {
        return decryptedString;
    }

    public static String getEncryptedString() {
        return encryptedString;
    }

    public static void setEncryptedString(String encryptedString) {
        AESPasswordEncryption.encryptedString = encryptedString;
    }

    public static String encrypt(String strToEncrypt) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secreteKey);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"");
        }
    }

    public static void main(String[] args) {

    }
}
