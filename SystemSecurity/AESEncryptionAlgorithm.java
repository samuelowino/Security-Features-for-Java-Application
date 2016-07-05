/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package SystemSecurity;

/**
 *
 * @author user
 */
//This class defines AESEncryption algorithm implementation in java
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import sun.misc.*;

public class AESEncryptionAlgorithm {

    private static final String algorithmDeclaration = "AES";
    private static final String keyValueString = "Thebestsecretkey";
    private static final byte[] keyValueBytes = keyValueString.getBytes();

    private static Key generateKey() throws Exception {

        Key key = new SecretKeySpec(keyValueBytes, algorithmDeclaration);
        return key;
    }

    @SuppressWarnings("unchecked")
    public static String encrypt(String plainText) throws Exception {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(algorithmDeclaration);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptValue = cipher.doFinal(plainText.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encryptValue);

        return encryptedValue;
    }

    @SuppressWarnings("unchecked")
    public static String decrypt(String cipherText) {
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(algorithmDeclaration);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decorderValue = new BASE64Decoder().decodeBuffer(cipherText);
            byte[] decValue = cipher.doFinal(decorderValue);
            String plainText = new String(decValue);

            return plainText;
        } catch (IllegalBlockSizeException e) {
          //  JOptionPane.showMessageDialog(null,"Error 111"+e.getMessage());
            e.printStackTrace();
            return null;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro 122"+e.getMessage());
            return null;
        }

    }

    public static void main(String[] args) {

        //while (true) {
        try {
            String userPassword = "xcdfvghbvgfcgvbh";
            String decrytptedCipher = "";
            String enteredPotentialPassword = "jamesgosling";
            Boolean isAuthenticated = false;
            
            //create a SecureRandom Object
            SecureRandom secureRandom = SecureRandom.getInstance(algorithmDeclaration);
            secureRandom.nextBytes(keyValueBytes);
            System.err.println(secureRandom.nextInt());

            encrypt(userPassword);
            decrytptedCipher = decrypt(userPassword);

            enteredPotentialPassword = JOptionPane.showInputDialog(null, "Enter Yout password");
            if (enteredPotentialPassword.equals(decrypt(userPassword))) {
                JOptionPane.showMessageDialog(null, "Log In succefull" + enteredPotentialPassword + ":" + decrypt(userPassword));
            } else if (!enteredPotentialPassword.equals(decrypt(userPassword))) {
                JOptionPane.showMessageDialog(null, "Wrong Password" + enteredPotentialPassword + ": " + decrypt(userPassword));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Encryption Error" + e.getMessage());
        }
        // }

    }

}
