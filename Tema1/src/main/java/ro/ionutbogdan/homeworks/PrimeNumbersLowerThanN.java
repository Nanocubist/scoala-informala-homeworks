package ro.ionutbogdan.homeworks;
import java.util.Scanner;

/**
 * In this program we will find and display all the prime numbers lower than a given number.
 * We will read the number from the keyboard.
 *
 * @author Ionut Bogdan
 */
public class PrimeNumbersLowerThanN {

    public static void main(String[] args) {
        int n = readNumber();
        System.out.println("Sunt " + countPrimes(n) + " numere prime mai mici decat " + n + ".");
        printPrime(n);
    }

    private static int readNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti valoarea lui n: ");
        int n = input.nextInt();
        return n;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; (i * i) <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void printPrime(int n) {
        for (int j = 2; j <= n; j++) {
            if (isPrime(j)) {
                System.out.println(j);
            }
        }
    }

    private static int countPrimes(int n) {
        int counter = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                counter++;
            }
        }
        return counter;
    }
}
