import java.util.*;

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
        int Key[];
        Key = createKey(arraySize);
        System.out.println("Array " + Arrays.toString(Key));
        Key = sortByBubbleSort(Key);
        System.out.println("Array bubble sort " + Arrays.toString(Key));

        Key = sortBySelectionSort(Key);
        System.out.println("Array selection sort " + Arrays.toString(Key));

        String EncodeString = cryptString(input, Key);
        System.out.println("Incode string \n" + EncodeString);
        String DecodeString = cryptString(EncodeString, Key);
        System.out.println("\nDecode string \n" + DecodeString);
    }

    public static int[] sortBySelectionSort(int[] Array) {
        int maxValueIndex;
        for (int i = 0; i < Array.length; i++) {
            maxValueIndex = getIndexOfMinElement(Array, i);
            if (maxValueIndex != i) {
                int temp = Array[i];
                Array[i] = Array[maxValueIndex];
                Array[maxValueIndex] = temp;
            }
        }
        return Array;
    }

    public static int getIndexOfMinElement(int[] Array, int startFrom) {
        int max = -2147483648;
        int indexMax = startFrom;
        for (int i = startFrom; i < Array.length; i++) {
            if (Array[i] > max) {
                max = Array[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static int[] createKey(int arraySize) {
        Random random = new Random();
        int Array[];
        Array = new int[arraySize];
        for (int j = 0; j < Array.length; j++) {
            Array[j] = random.nextInt(10);
        }
        return Array;
    }

    public static int[] sortByBubbleSort(int[] Array) {
        for (int i = Array.length - 1; i >= 2; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (Array[j] > Array[j + 1]) {
                    int temp = Array[j];
                    Array[j] = Array[j + 1];
                    Array[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return Array;
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
