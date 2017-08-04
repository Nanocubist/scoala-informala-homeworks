package ro.ionutbogdan.homeworks;
import java.util.Scanner;

/**
 * This program will display the max digit from a number.
 * Again, we will extend the problem to read the number from keyboard.
 *
 * @author Ionut Bogdan
 */
public class MaxDigitFromNumber {

    public static void main(String[] args) {
        long n = readNumber();
        long max = findMax(n);
        System.out.println("Cea mai mare cifra a numarului " + n + " este cifra " + max + ".");

    }

    private static long readNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti numarul dorit: (long type expected) ");
        return input.nextLong();
    }

    private static long findMax(long n) {
        long max = 0;
        while (n != 0) {
            long nActual = n % 10;
            if (nActual > max) {
                max = nActual;
            }
            n = n / 10;
        }
        return max;
    }
}
