package ro.ionutbogdan.homeworks;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Display the smallest number from an array of numbers.
 * We will extend the problem to read the array from keyboard.
 *
 * @author Ionut Bogdan
 */
public class SmallestNumber {
    public static int sir[];

    public static void main(String[] args) {
        System.out.println("Vom afisa cel mai mic element al unui sir citit de la tastatura.");
        readArray();
        System.out.println("Din sirul " + Arrays.toString(sir) + ", " + "cel mai mic element este " + theSmallest(sir) + ".");
    }


    private static void readArray() {
        Scanner keyboardRead = new Scanner(System.in);
        System.out.println("Cate elemente doriti sa aiba sirul?");
        int n = keyboardRead.nextInt();
        sir = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.println("Introduceti primul element: ");
                sir[i] = keyboardRead.nextInt();
            } else if (i == (n - 1)) {
                System.out.println("Introduceti ultimul element: ");
                sir[i] = keyboardRead.nextInt();
            } else {
                System.out.println("Introduceti urmatorul element: ");
                sir[i] = keyboardRead.nextInt();
            }
        }

    }

    private static int theSmallest(int[] someArray) {
        int smallest = someArray[0];
        for (int i = 1; i < someArray.length; i++) {
            if (someArray[i] < smallest) {
                smallest = someArray[i];
            }
        }
        return smallest;
    }
}
