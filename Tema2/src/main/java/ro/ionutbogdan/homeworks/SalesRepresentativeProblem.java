package ro.ionutbogdan.homeworks;

/**
 * This program implements a bubble sort algorithm to sort an array of SalesRepresentative objects in descending order.
 *
 * @author Ionut Bogdan
 */

public class SalesRepresentativeProblem {
    static SalesPersons[] salesPers = new SalesPersons[10];

    /**
     * In the main method we initialize 10 sale persons and after that using the methods created lower we sort the array.
     * We display the first array unsorted and than after using bubbleSortMethod we print it sorted.
     *
     * @author Ionut Bogdan
     */
    public static void main(String[] args) {
        initSalesPerson(0, "Marius", 16, 250);
        initSalesPerson(1, "Alin", 5, 375);
        initSalesPerson(2, "Raul", 20, 225);
        initSalesPerson(3, "Zorin", 37, 75);
        initSalesPerson(4, "Nati", 11, 380);
        initSalesPerson(5, "Tudor", 9, 395);
        initSalesPerson(6, "Abel", 26, 195);
        initSalesPerson(7, "David", 31, 95);
        initSalesPerson(8, "Zoli", 40, 68);
        initSalesPerson(9, "Emil", 7, 410);

        System.out.println("______________________________ This is the unsorted array: _____________________________");
        System.out.println("________________________________________________________________________________________");
        displayArray(salesPers);
        bubbleSortMethod(salesPers);
        System.out.println("________________________________________________________________________________________");
        System.out.println("__________________________ The Bubble Sort process took place! _________________________");
        System.out.println("________________________________________________________________________________________");
        System.out.println("_________________ This is how the array looks after sorting process: ___________________");
        System.out.println("________________________________________________________________________________________");
        displayArray(salesPers);
        System.out.println("________________________________________________________________________________________");
    }

    /**
     * This method creates and initializes sale persons.
     * @param position      - the position in the array
     * @param name          - the name that will be given to that specific sale person
     * @param numberOfSales - the number of sales that sales person has done
     * @param quota         - the specific quota that person's sales have.
     * @author Ionut Bogdan
     */
    private static void initSalesPerson(int position, String name, int numberOfSales, int quota) {
        salesPers[position] = new SalesPersons();
        salesPers[position].name = name;
        salesPers[position].numberOfSales = numberOfSales;
        salesPers[position].quota = quota;
    }

    private static int computeRevenueGenerated(SalesPersons person) {
        return person.numberOfSales * person.quota;
    }

    private static void displayArray(SalesPersons array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Sales guy " + array[i].name + " has " + array[i].numberOfSales
                    + " sales" + " with a quota of " + array[i].quota + "$. He has achived "
                    + computeRevenueGenerated(array[i]) + "$"
                    + " worth of sales.");
        }

    }

    private static void bubbleSortMethod(SalesPersons[] arrayOfPersons) {
        SalesPersons temp;
        for (int i = 0; i < arrayOfPersons.length; i++) {
            for (int j = 1; j < (arrayOfPersons.length - i); j++) {
                if (computeRevenueGenerated(arrayOfPersons[j - 1]) < computeRevenueGenerated(arrayOfPersons[j])) {
                    temp = arrayOfPersons[j - 1];
                    (arrayOfPersons[j - 1]) = (arrayOfPersons[j]);
                    (arrayOfPersons[j]) = temp;
                }
            }
        }
    }
}
