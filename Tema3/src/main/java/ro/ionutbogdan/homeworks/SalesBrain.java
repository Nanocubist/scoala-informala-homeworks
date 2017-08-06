package ro.ionutbogdan.homeworks;

/**
 * This program solves the problem from Homework 3:
 *
 * Extend the previous homework with the following functionality:
 * The company has 4, SalesDepartments where every department has a team of 5 SalesRepresentatives.
 * In addition to the statistics generated in the previous homework compute the following:
 * How much total sales has the company achieved.
 * Which is the most successful department? (which one has the most sales)
 * Who is the best sales rep in the entire company (from all departments).
 * 
 * SalesBrain class contains all the initialization and computing neccesary to solve the problem.
 *
 * @author Ionut Bogdan
 */
public class SalesBrain {

    static SalesPersons[] salesPers = new SalesPersons[20];
    static SalesDepartment[] salesDepartments = new SalesDepartment[4];
    static SalesCompany[] salesCompanies = new SalesCompany[1];

    public static void main(String[] args) {

        initSalesCompany(0, "Compania 1", 4);

        initSalesDepartment(0, "Departamentul 1", 5);
        initSalesDepartment(1, "Departamentul 2", 5);
        initSalesDepartment(2, "Departamentul 3", 5);
        initSalesDepartment(3, "Departamentul 4", 5);

        initSalesPerson(0, "Marius", 16, 250, 0);
        initSalesPerson(1, "Alin", 5, 375, 0);
        initSalesPerson(2, "Raul", 20, 225, 0);
        initSalesPerson(3, "Zorin", 37, 75, 0);
        initSalesPerson(4, "Nati", 11, 380, 0);

        initSalesPerson(5, "Tudor", 9, 395, 1);
        initSalesPerson(6, "Abel", 26, 195, 1);
        initSalesPerson(7, "David", 31, 95, 1);
        initSalesPerson(8, "Zoli", 40, 68, 1);
        initSalesPerson(9, "Emil", 7, 410, 1);

        initSalesPerson(10, "Mirela", 17, 245, 2);
        initSalesPerson(11, "Stalin", 34, 123, 2);
        initSalesPerson(12, "Hitler", 18, 154, 2);
        initSalesPerson(13, "Cosmin", 24, 35, 2);
        initSalesPerson(14, "Laura", 13, 199, 2);

        initSalesPerson(15, "Vasilica", 21, 214, 3);
        initSalesPerson(16, "Ionela", 3, 358, 3);
        initSalesPerson(17, "Nuțu", 24, 127, 3);
        initSalesPerson(18, "Timotei", 29, 452, 3);
        initSalesPerson(19, "Ruben", 18, 134, 3);

        System.out.println("The sorted array of SalesPersons follows: ");
        System.out.println("________________________________________________________________________________________");
        bubbleSortMethod(salesPers);
        displayArray(salesPers);
        System.out.println("________________________________________________________________________________________");
        System.out.println("The company has achieved " + getTotalSalesOfCompany(salesPers) + " sales. That's " +
                getTotalRevenueOfCompany(salesPers) + "$ in revenue.");
        System.out.println("________________________________________________________________________________________");
        System.out.println("The best sales person in the entire company is: "
                + getBestSalePerson(salesPers).name + " !!!");
        System.out.println("________________________________________________________________________________________");
        System.out.println("The most successful department (considering sales number) is: "
                + mostSuccesfulDepartment(salesPers));
        System.out.println("________________________________________________________________________________________");

    }

    private static void initSalesPerson(int position, String name, int numberOfSales, int quota, int department) {
        salesPers[position] = new SalesPersons();
        salesPers[position].name = name;
        salesPers[position].numberOfSales = numberOfSales;
        salesPers[position].quota = quota;
        salesPers[position].memberOfDepartment = department;
    }

    private static void initSalesDepartment(int position, String name, int numberOfSalesPersons) {
        salesDepartments[position] = new SalesDepartment();
        salesDepartments[position].name = name;
        salesDepartments[position].numberOfSalesPersons = numberOfSalesPersons;
    }

    private static void initSalesCompany(int position, String name, int numberOfDepartments) {
        salesCompanies[position] = new SalesCompany();
        salesCompanies[position].name = name;
        salesCompanies[position].numberOfDepartments = numberOfDepartments;
    }

    private static void displayArray(SalesPersons array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Sales guy " + array[i].name + " has " + array[i].numberOfSales
                    + " sales" + " with a quota of " + array[i].quota + "$. He has achived "
                    + computeRevenueGenerated(array[i]) + "$"
                    + " worth of sales.");
        }

    }

    private static int computeRevenueGenerated(SalesPersons person) {
        return person.numberOfSales * person.quota;
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

    private static SalesPersons getBestSalePerson(SalesPersons[] array) {
        bubbleSortMethod(array);
        SalesPersons bestSalePerson = array[0];
        return bestSalePerson;
    }

    private static int getTotalSalesOfCompany(SalesPersons[] array) {
        int totalSales = 0;
        for (int i = 0; i < array.length; i++) {
            totalSales = totalSales + array[i].numberOfSales;
        }
        return totalSales;
    }

    private static int getTotalRevenueOfCompany(SalesPersons[] array) {
        int totalRevenue = 0;
        for (int i = 0; i < array.length; i++) {
            totalRevenue = totalRevenue + computeRevenueGenerated(array[i]);
        }
        return totalRevenue;
    }

    private static String mostSuccesfulDepartment(SalesPersons[] array) {
        int totalSalesDep1 = 0;
        int totalSalesDep2 = 0;
        int totalSalesDep3 = 0;
        int totalSalesDep4 = 0;
        int SalesDepartmentsArray[] = {totalSalesDep1, totalSalesDep2, totalSalesDep3, totalSalesDep4};
        String SalesDepartmentsArrayNames[] = {"Department 1", "Department 2", "Department 3", "Department 4"};
        int winnerDepartment = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].memberOfDepartment == 1) {
                totalSalesDep1 += array[i].numberOfSales;
            } else if (array[i].memberOfDepartment == 2) {
                totalSalesDep2 += array[i].numberOfSales;
            } else if (array[i].memberOfDepartment == 3) {
                totalSalesDep3 += array[i].numberOfSales;
            } else {
                totalSalesDep4 += array[i].numberOfSales;
            }

        }

        System.out.println("Departamentul 1 has: " + totalSalesDep1 + " sales.");
        System.out.println("Departamentul 2 has: " + totalSalesDep2 + " sales.");
        System.out.println("Departamentul 3 has: " + totalSalesDep3 + " sales.");
        System.out.println("Departamentul 4 has: " + totalSalesDep4 + " sales.");
        System.out.println("________________________________________________________________________________________");

        for (int i = 0; i <= 3; i++) {
            if (SalesDepartmentsArray[i] > winnerDepartment) {
                winnerDepartment = SalesDepartmentsArray[i];
            }
        }
        return SalesDepartmentsArrayNames[winnerDepartment];
    }
}


