package ro.ionutbogdan.homeworks;

import java.util.Scanner;

/**
 * This program will check if a number is palindrom (e.g. of palindrom: 1221, 34143).
 * We will read the number from the keyboard.
 *
 * @author Ionut Bogdan
 */
public class CheckIfPalindrom {

    /**
     * In metoda main folosim metodele create pentru a citi numarul de la tastatura
     * si pentru a verifica daca acel numar este palindrom sau nu.
     * Metodele folosite sunt readNumber(), respectiv isPalindrom().
     */
    public static void main(String[] args) {
        int number = readNumber();
        if (isPalindrom(number)) {
            System.out.println("Numarul " + number + " este palindrom!");
        } else {
            System.out.println("Numarul " + number + " nu este palindrom!");
        }
    }

    private static int readNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti numarul dorit: (int type expected) ");
        return input.nextInt();
    }

    private static boolean isPalindrom(int number) {
        int reverse = 0;
        int palindrome = number;
        while (palindrome != 0) {
            int rest = palindrome % 10;
            reverse = reverse * 10 + rest;
            palindrome = palindrome / 10;
        }

        if (reverse == number) {
            return true;
        } else {
            return false;
        }


    }
}
