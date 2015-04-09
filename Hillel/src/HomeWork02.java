import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by Давидчук_ИВ on 08/04/15.
 */
public class HomeWork02 {
    public static void main(String[] params ){
        // Shifr
        System.out.println("Input string for decoding");
        Scanner scaner = new Scanner(System.in);
        String input = scaner.nextLine();
        char myKey = '7';

        String myIncodeString = cryptString(input, myKey);
        System.out.println("myIncodeString \n" + myIncodeString);
        String myDecodeString = cryptString(myIncodeString, myKey);
        System.out.println("\nmyDecodeString \n" + myDecodeString);
    }
    public static String cryptString(String strtingMessage, char key){
        char[] chars = strtingMessage.toCharArray();
        //System.out.println(Arrays.toString(chars));
        for (int i=0; i< chars.length; i++){
            chars[i] ^= key;}
        String someString = String.copyValueOf(chars);
        return someString;
    }
  }
