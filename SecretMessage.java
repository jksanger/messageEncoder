
package secretmessage;

import java.util.Scanner;
/**
 *
 * @author Joseph Sanger 1527317
 * 
 * This program will take the users input and change the characters to
 * a decoded message. It can also take the decoded message and replace it
 * to an encoded message
 */
public class SecretMessage {

    public static void main(String[] args) {
      
       // get input from the user and encode/decode until user quits
       Scanner scan = new Scanner(System.in);
      
       //variable for userInput
       String userInput;
      
       //prompts user for input
       System.out.print("Enter 'e' to encode, 'd' to decode, 'q' to quit: ");
       userInput = scan.nextLine();
      
      
       //while loop the user does not enter q to quit, in any case
       
       while (!userInput.equals("q") && !userInput.equals("Q"))
       {
           //encrypt
           if(userInput.equals("e") || userInput.equals("E"))
           {
               //prompts user for input and stores in encodedMessage then outputs
               System.out.println("Enter the text to encode: ");
               String userMessage = scan.nextLine();
               String encodedMessage = codeMessage(userMessage, true);
               System.out.println(encodedMessage);
           }
           //decrypt
           else if (userInput.equals("d") || userInput.equals("D"))
           {
               //prompts user for input and stores in decodedMessage then outputs
               System.out.println("Enter the text to decode: ");
               String userMessage = scan.nextLine();
               String decodedMessage = codeMessage(userMessage, false);
               System.out.println(decodedMessage);
           }
           //if e,d,q is not entered, continue prompting user 
           System.out.print("Enter 'e' to encode, 'd' to decode, 'q' to quit: ");
           userInput = scan.nextLine();
          
      
              
       }
       //quit message
       System.out.println("Good bye!");
      
      
   }
   //true/false boolean statements
    public static boolean isLowerCaseLetter(char c) {
       
       return c >= 'a' && c <= 'z';
   }

   public static boolean isUpperCaseLetter(char c) {
       return c>= 'A' && c<= 'Z';
      
   }

   public static boolean isLetter(char c) {
       //use previous methods to compare if letter
       return isLowerCaseLetter(c) || isUpperCaseLetter(c);
   }

   public static char toLowerCase(char c) {
       //char casts based on ascii offset mapping
       return (char) (c + 'a' - 'A');
   }
  
   public static char toUpperCase(char c) {
       //since upper case, use index obtained by summing lower and uppercase offset, then casting
       return (char) (c - 'a' + 'A');
   }
  
   public static char codeChar(char c, boolean encode) {  
      
       //String letters = "abcdefghijklmnopqrstuvwxyz";
       String ENC_KEY = "kngcadsxbvfhjtiumylzqropwe";
       String DEC_KEY = "eidfzkclomasqbwxuvgnpjyhrt";
      
       //initialize new character
       char newChar = c;
      
       if(isLetter(c))
       {
          
           if(isUpperCaseLetter(c))
           {
               //if encode is true then encrypt
               if (encode)
                   //new character 
                   newChar = ENC_KEY.charAt(c-'A');
               //if decode is true then decode
               else
               {
                   newChar = DEC_KEY.charAt(c- 'A');
               }
               //convert to uppercase
               newChar = toUpperCase(newChar);
           }
           //perform same operation if lower case
           else
           {
               if (encode)
                   newChar = ENC_KEY.charAt(c-'a');
               else
                   newChar = DEC_KEY.charAt(c - 'a');
           }
       }
              
      
       return newChar;
   }
  
   public static String codeMessage(String message, boolean encode)
   {
       //initialize string to hold new message
       String newMessage = "";
       //for each letter in desired message
       for(int i = 0;i<message.length();i++)
       {
           //add onto new message by calling the corresponding en/decrypted character
           newMessage += codeChar(message.charAt(i), encode);
       }
       return newMessage;
   }
  
}