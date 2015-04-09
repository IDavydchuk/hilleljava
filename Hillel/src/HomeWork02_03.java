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
        int key[];
        key = createKey(arraySize);
        System.out.println("Array " + Arrays.toString(key));
        key = sortByBubbleSort(key);
        System.out.println("Array bubble sort " + Arrays.toString(key));

        key = sortBySelectionSort(key);
        System.out.println("Array selection sort " + Arrays.toString(key));

        String encodeString = cryptString(input, key);
        System.out.println("Incode string \n" + encodeString);
        String decodeString = cryptString(encodeString, key);
        System.out.println("\nDecode string \n" + decodeString);
    }

    public static int[] sortBySelectionSort(int[] array) {
        int maxValueIndex;
        for (int i = 0; i < array.length; i++) {
            maxValueIndex = getIndexOfMaxElement(array, i);
            if (maxValueIndex != i) {
                int temp = array[i];
                array[i] = array[maxValueIndex];
                array[maxValueIndex] = temp;
            }
        }
        return array;
    }

    public static int getIndexOfMaxElement(int[] array, int startFrom) {
        int max = Integer.MIN_VALUE;
        int indexMax = startFrom;
        for (int i = startFrom; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static int[] createKey(int arraySize) {
        Random random = new Random();
        int array[];
        array = new int[arraySize];
        for (int j = 0; j < array.length; j++) {
            array[j] = random.nextInt(10);
        }
        return array;
    }

    public static int[] sortByBubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 2; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
        return array;
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
