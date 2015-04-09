import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by ��������_�� on 09/04/15.
 */
public class HomeWork02_03 {
    public static void main(String[] params ){
        // Shifr
        int arraySize;//
        System.out.println("Input size array");
        Scanner inputArraySize = new Scanner(System.in);
        arraySize = inputArraySize.nextInt();

        System.out.println("Input string for decoding");
        Scanner scaner = new Scanner(System.in);
        String input = scaner.nextLine();
        int myKey[];
        myKey = createMyKey(arraySize);

        String myEncodeString = cryptString(input, myKey);
        System.out.println("myIncodeString \n" + myEncodeString);
        String myDecodeString = cryptString(myEncodeString, myKey);
        System.out.println("\nmyDecodeString \n" + myDecodeString);
    }
    public static int[] createMyKey(int arraySize){
        Random random = new Random();
        int myArray[];
        myArray = new int[arraySize];
        for (int j=0; j < myArray.length; j++){
            myArray[j]= random.nextInt(10);}
        System.out.println("myArray "+Arrays.toString(myArray));
        myArray = sortMyArrayBooble(myArray);
        System.out.println("myArraySort "+Arrays.toString(myArray));
        return myArray;
    }
    public static int[] sortMyArrayBooble(int[] myArray){
        for (int i = myArray.length - 1; i >= 2; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (myArray[j] > myArray[j+1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                    sorted = false;
                }
            }
        }
        return myArray;
    }
    public static String cryptString(String strtingMessage, int[] key){
        char[] chars = strtingMessage.toCharArray();
        int incr;
        //System.out.println(Arrays.toString(chars));
        for (int i=0; i< chars.length; i++){
            if (chars.length >= key.length){
                incr = i- Math.abs(i/key.length)*key.length;
                chars[i] ^= key[incr];
            }
            else {
                chars[i] ^= key[i];
            }
        }
        String someString = String.copyValueOf(chars);
        return someString;
    }
}