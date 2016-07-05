/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package SystemSecurity;

/**
 *
 * @author samuel owino
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

public class SHA1PasswordHashing {

    private static final String salt = "74uidfccn6m4okjeq1lbjq7gru727k814vm7d81u74uidfccn6m4okjeq1lb";
    private static String generatedHashedPassword = null;
    private static byte[] hashedPasswordBytes;

    /**
     * Creates and returns 60 byte hash for the entered password
     *
     * @param password
     * @return
     */
    public static final String hashPassword(String password) {
        try {
            
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256"); 
            messageDigest.update(password.getBytes());
            hashedPasswordBytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            
            for(int i = 0;i<hashedPasswordBytes.length;i++){
                stringBuilder.append(Integer.toString((hashedPasswordBytes[i] & 0xff)+ 0x100,32).substring(1));
            }
            generatedHashedPassword = stringBuilder.toString();
            return generatedHashedPassword+salt;
            
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(null,"Security Error","Alpha Phamarcy POS",JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    /**
     * Compare entered password hash with existing hash for this 
     * particular user.
     * @param passwordHash
     * @param enteredHash
     * @return
     */
    public static final boolean comparePasswords(String passwordHash,String enteredHash) {
        
        if(passwordHash.equals(enteredHash)){
            return true;
        }else if(passwordHash.equals(enteredHash)== false){
            return false;
        }else {
            JOptionPane.showConfirmDialog(null,"Non expected Error occured");
            return false;
        }
        
    }
    
    //@Test STATUS = SUCCESS
    public static void main(String[] args) {
    String hash = SHA1PasswordHashing.hashPassword("sam");
    System.out.println("sam - hashed  \n"+hash);
    
    String enteredPassword = JOptionPane.showInputDialog(null,"Entered Password");
    String hash2 = SHA1PasswordHashing.hashPassword(enteredPassword);
    System.out.println("Enterd sam pass hashed\n"+hash2);
    
    
    if(SHA1PasswordHashing.comparePasswords(hash, SHA1PasswordHashing.hashPassword(enteredPassword))){
    JOptionPane.showMessageDialog(null,"Wow! you ..crucked it..");
    }else if(!SHA1PasswordHashing.comparePasswords(hash, SHA1PasswordHashing.hashPassword(enteredPassword))){
    JOptionPane.showMessageDialog(null,"WRONG PASSWORD...");
    }
    }

}
