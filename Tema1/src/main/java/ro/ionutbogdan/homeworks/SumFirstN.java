package ro.ionutbogdan.homeworks;
import java.util.Scanner;

/**
 * Created by Ionut Bogdan on 13.07.2017.
 * Problem 1 from Homework 1: calculate the sum of the first 100 numbers higher than 0.
 * Problema a fost extinsa cu citirea lui n de la tastatura si prin folosirea instructiunilor
 * conditionale FOR, WHILE, DO WHILE pentru calculul sumei (just for fun).
 */
public class SumFirstN {

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            openingMethod();
        }
    }

    /**
     * In aceasta metoda citim de la tastatura valoarea numarului dorit.
     * Apoi, invocand metodele create ulterior afisam suma primelor n numere.
     */
    public static void openingMethod() {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Introduceti valoarea lui n: (Integer Expected)");
        int n = keyboardInput.nextInt();
        if (n > 0) {
            System.out.println("Vom calcula suma primelor " + n + " numere >0: ");
            System.out.println("Folosind FOR LOOP suma este: " + usingFor(n));
            System.out.println("Folosind WHILE LOOP suma este: " + usingWhile(n));
            System.out.println("Folosind DO WHILE LOOP suma este: " + usingDoWhile(n));
            System.exit(0);
        } else {
            System.out.println("Te rog introdu un n mai mare ca 0");
        }
    }

    /**
     * Metoda usingFor foloseste instructiunea conditionala FOR pentru a face suma a primelor n numere mai mari ca 0.
     *
     * @param n reprezinta argumentul metodei.
     * @return returneaza rezultatul sumei.
     * @author Ionut Bogdan.
     */
    public static int usingFor(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum = i + sum;
        }
        return sum;

    }

    public static int usingWhile(int n) {
        int sum = 0;
        int i = 1;
        while (n > 0 && i <= n) {
            sum = i + sum;
            i++;
        }
        return sum;

    }

    public static int usingDoWhile(int n) {
        int sum = 0;
        int i = 1;
        do {
            sum = i + sum;
            i++;
        } while (n > 0 && i <= n);
        return sum;

    }
}