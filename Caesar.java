
/**
 * A subclass of MonoAlphaSubstitution called Caesar that use shift to encrypt or decrypt 
 * 
*/
public class Caesar extends MonoAlphaSubstitution {

    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    String upperalphabeString ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int shift;

 /**
     * encrypt the code
     *
     * @param c the character from MonoAlphaSubstitution
     * @return rotatedC 
     */
    public char encrypt(char c){

        char rotatedC = rotate(this.shift, c); //calling the rotated character by giving the shift and character

        return rotatedC;
    }
    /**
     * decrypt the code
     *
     * @param c the character from MonoAlphaSubstitution
     * @return derotatedC 
     */
    public char decrypt(char c){

        char derotatedC = rotate(26-this.shift, c); // reverse the encrytion by -26 to the shift and add it to the character

        return derotatedC;
    }
 /**
     * rotate the code with given shift
     *
     * @param shift the shift of the encryption or decryption
     * @param ch the character to rotate
     * @return cipherChar
     */
    public char rotate(int shift, char ch){

        if (Character.isLetter(ch) == false){
            return ch;
        }
        char cipherChar;

        if (Character.isLowerCase(ch)){
            int charIndex = alphabet.indexOf(ch); //finding the index number of character in the alphabet
            int newIndex = (charIndex + shift)%26; // add the index with the given shift 
            if (newIndex<0){
                newIndex = newIndex + 26;}
            cipherChar = alphabet.charAt(newIndex); 
        }
        else {
            int charIndex = upperalphabeString.indexOf(ch); //Uppercase part
            int newIndex = (charIndex + shift)%26;
            if (newIndex<0){
                newIndex = newIndex + 26;}
            cipherChar = upperalphabeString.charAt(newIndex);

        }
        return cipherChar;
    }

    /**
     * a default constructor that has no paramter
     */
    public Caesar() {
        this.shift = 0;
    }
/**
     * a constructor with int 
     *
     * @param keyShift
     */
    public Caesar (int keyShift){
        this.shift = keyShift;
    }

/**
 * A main method to run the program
 * 
 * @param args arguments for parameters
 */   
public static void main(String[] args) {


    if (args.length==3){

        Caesar caesar = new Caesar(Integer.parseInt(args[1]));

        if (args[0].equals("encrypt")){
            System.out.println(caesar.encrypt(args[2]));
        }
        else if (args[0].equals("decrypt") ){
            System.out.print(caesar.decrypt(args[2]));
        }
        else{
            System.out.println("The first parameter must be \"encrypt\" or \"decrypt\"!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key \"cipher text\"");
        }

    }
    else if (args.length >3){
        System.out.println("Too many parameters!");
        System.out.println("Usage: java Caesar encrypt n \"cipher text\"");

    }
    else{
        System.out.println("Too few parameters!");
        System.out.println("Usage: java Caesar encrypt n \"cipher text\"");
    }

}
}
