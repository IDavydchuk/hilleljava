import java.util.Arrays;
import java.util.Scanner;
/**
 * Created by ��������_�� on 08/04/15.
 */
public class HomeWork02 {
    public static void main(String[] params ){
        // Shifr
        System.out.println("Input string for decoding");
        Scanner scaner = new Scanner(System.in);
        String input = scaner.nextLine();
        char myKey = '7';

        String myDecodeString = cryptString(input, myKey);
        System.out.println("myDecodeString \n" + myDecodeString);
        String myIncodeString = cryptString(myDecodeString, myKey);
        System.out.println("\nmyIncodeString \n" + myIncodeString);
    }
    public static String cryptString(String strtingMessage, char key){
        char[] chars = strtingMessage.toCharArray();
        //System.out.println(Arrays.toString(chars));
        //incoding
        for (int i=0; i< chars.length; i++){
            chars[i] ^= key;}
        //System.out.println(Arrays.toString(chars));
        String someString = String.copyValueOf(chars);
        return someString;
    }
    /*
    public static String StringDeCrypt (String strtingMessage, char key ){
        char[] chars = strtingMessage.toCharArray();
        //decoding
        for (int i=0; i< chars.length; i++)
            chars[i] ^= key;
        String someString = String.copyValueOf(chars);
        return someString;
    }*/
}
