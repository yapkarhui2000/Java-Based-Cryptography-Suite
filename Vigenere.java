
/**
 * A subclass of Vigenere called Substitution that use secret keyword to encrypt and decrypt
 * 
*/
public class Vigenere extends Substitution{
    
    private Caesar[] cipher;
    private int counter;
    /**
     * Encrypt the code 
     *
     * @param c character from Substitution
     * @return encryptedC 
     */  
    public char encrypt(char c){
        
        char encryptedC = this.cipher[this.counter%cipher.length].encrypt(c) ;
        
        counter++;

        return encryptedC;
    }
    /**
     * Decrypt the code 
     *
     * @param c character from Substitution
     * @return decryptedC 
     */  
    public char decrypt(char c){

        char decryptedC = this.cipher[this.counter%cipher.length].decrypt(c);

        counter++;

        return decryptedC;
    }
     /**
     * a default constructor that has no paramter
     *
     */
    public Vigenere(){
    }
    /**
     * A constructor that take keyword and encrypt it 
     *
     * @param keyword the secret keyword for encryption and decryption
     *
     */
    public Vigenere(String keyword){

        this.cipher = new Caesar[keyword.length()];

        counter = 0;

        for (int i = 0; i <keyword.length(); i++){
            char x = keyword.charAt(i); //To find the character at keyword
            int shift = (int)x - (int)'A';  //To find the shift 
            Caesar encrpytion = new Caesar(shift);
            this.cipher[i] = encrpytion; // put the encryption into the array
        }
    }
    /**
    * A main method to run the program
    * 
    * @param args arguments for parameters
    */   
    public static void main(String[] args) {

        if (args.length==3){
    
            Vigenere vigenere = new Vigenere(args[1]);
    
            if (args[0].equals("encrypt")){
                System.out.print(vigenere.encrypt(args[2]));
            }
    
            else if (args[0].equals("decrypt") ){
                System.out.print(vigenere.decrypt(args[2]));
            }
            else{
                System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
                System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
            }
    
        }
        else if (args.length >3){
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
    
        }
        else{
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Vigenere encrypt key \"cipher text\"");
        }
    
    
    }
    
    }
    