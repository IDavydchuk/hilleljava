import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Давидчук_ИВ on 09/04/15.
 */
public class HomeWork02_03 {
    public static void main(String[] params) {
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
        System.out.println("myArray " + Arrays.toString(myKey));
        myKey = sortMyArrayBooble(myKey);
        System.out.println("myArraySort " + Arrays.toString(myKey));

        myKey = sortMyArrayChoice(myKey);
        System.out.println("myArrayChoice " + Arrays.toString(myKey));

        String myEncodeString = cryptString(input, myKey);
        System.out.println("myIncodeString \n" + myEncodeString);
        String myDecodeString = cryptString(myEncodeString, myKey);
        System.out.println("\nmyDecodeString \n" + myDecodeString);
    }

    public static int[] sortMyArrayChoice(int[] myArray) {
        int myIndex;
        for (int i = 0; i < myArray.length; i++) {
            int temp = myArray[i];
            myIndex = getIndexOfMinElement(myArray, i, temp);
            if (myIndex != i) {
                myArray[i] = myArray[myIndex];
                myArray[myIndex] = temp;
            }
        }
        return myArray;
    }

    public static int getIndexOfMinElement(int[] myArray, int startFrom, int temp) {
        int max = 0;
        int indexMax = startFrom;
        for (int i = startFrom; i < myArray.length; i++) {
            if (myArray[i] > max) {
                max = myArray[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static int[] createMyKey(int arraySize) {
        Random random = new Random();
        int myArray[];
        myArray = new int[arraySize];
        for (int j = 0; j < myArray.length; j++) {
            myArray[j] = random.nextInt(10);
        }
        return myArray;
    }

    public static int[] sortMyArrayBooble(int[] myArray) {
        for (int i = myArray.length - 1; i >= 2; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (myArray[j] > myArray[j + 1]) {
                    int temp = myArray[j];
                    myArray[j] = myArray[j + 1];
                    myArray[j + 1] = temp;
                    sorted = false;
                }
            }
        }
        return myArray;
    }

    public static String cryptString(String strtingMessage, int[] key) {
        char[] chars = strtingMessage.toCharArray();
        int incr;
        //System.out.println(Arrays.toString(chars));
        for (int i = 0; i < chars.length; i++) {
            incr = i % key.length;
            chars[i] ^= key[incr];
        }
        String someString = String.copyValueOf(chars);
        return someString;
    }
}
