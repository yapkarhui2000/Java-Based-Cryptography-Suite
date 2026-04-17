
/**
 * An abstract class that implements from the given interface Cipher
 * 
*/
public abstract class Substitution implements Cipher{
   /**
    * An abstract class for encrypt
    * 
    */
    public abstract char encrypt(char c);
    
     /**
    * An abstract class for decrypt
    * 
    */
    public abstract char decrypt(char c);
    
    /**
     * Encrypt the code 
     *
     * @param plaintext the plain text to encode
     * @return the encrypted text
     */
    public String encrypt(String plaintext){
        String encryptedText = "";
        for (int i = 0; i< plaintext.length() ; i++){
            char x  = plaintext.charAt(i); //to take the character of plaintext at every positions
            char y = encrypt(x); // encrypt every character in the plaintext 
            encryptedText = encryptedText + y; // add encrypted character to the empty string 
        }
        return encryptedText;
    }

    /**
     * Decrypt the code
     *
     * @param cryptotext the cryptotext
     * @return the encrypted text
     */
    public String decrypt (String cryptotext){
        String decryptedText = "";
        for (int i = 0; i< cryptotext.length() ; i++){
            char x  = cryptotext.charAt(i); //to take every chracter of cryptotext 
            char y = decrypt(x); //decrypt every character in cryptotext
            decryptedText = decryptedText + y; // add decrypted character to empty string
        }
        return decryptedText;
    }

    }