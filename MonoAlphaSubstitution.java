
import java.util.HashMap;
/**
 * A subclass of Substitution called MonoAlphaSubstitution that use translation table to encrypt or decrypt 
 * 
*/
public class MonoAlphaSubstitution extends Substitution {

    HashMap <Character, Character> decryptionTable = new HashMap <Character, Character>() ; 

    HashMap <Character, Character> translationTable = new HashMap <Character, Character>() ;
  
     /**
     * Encrypt the code 
     *
     * @param c the character overide from Substitution
     * @return the encrypted text
     */
    public char encrypt(char c){

        if (!this.translationTable.containsKey(c)){ // if the translation does not contain the character map it onto itself
            return c;
        }

        char x = this.translationTable.get(c); // return the value after translated using key

        return x;

    }
      /**
     * Dencrypt the code 
     *
     * @param c the character overide from Substitution
     * @return the decrypted text
     */
    public char decrypt(char c){

        if (!this.decryptionTable.containsKey(c)){ // if the translation does not contain the character map it onto itself
            return c;
        }

        char z = this.decryptionTable.get(c);  // return the value after translated using key

        return z;

    }
     /**
     * a default constructor that has no paramter
     *
     */
    public MonoAlphaSubstitution(){

    }
    
     /**
     * implement the translation table using Hashmap 
     *
     * @param encryptionKey the given key for encryption
     */
    public MonoAlphaSubstitution (String encryptionKey){

        for (int j=0; j<encryptionKey.length() ; j=j+2){
            //translationTable overides with encrytion key
            this.translationTable.put(encryptionKey.charAt(j), encryptionKey.charAt(j+1));
        }

        for (char k : translationTable.keySet()) {
            // the reverse way of encryption by reading the translation table as key and reutrn decrypted value
            this.decryptionTable.put(translationTable.get(k), k);

        }
    }

/**
 * A main method to run the program
 * 
 * @param args arguments for parameters
 */   
public static void main(String[] args) {

    if (args.length==3){

        MonoAlphaSubstitution monoalphasubstituion = new MonoAlphaSubstitution(args[1]);

        if (args[0].equals("encrypt")){
            System.out.print(monoalphasubstituion.encrypt(args[2]));
        }

        else if (args[0].equals("decrypt") ){
            System.out.print(monoalphasubstituion.decrypt(args[2]));
        }
        else{
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

    }
    else if (args.length >3){
        System.out.println("Too many parameters!");
        System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");

    }
    else{
        System.out.println("Too few parameters!");
        System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
    }


}

}

