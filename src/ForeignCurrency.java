import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;

public class ForeignCurrency {

    static Scanner sc = new Scanner(System.in);
//    static double rEUR, rGBP;
//rates array for exchangeRates

    static double[] cRates;
    static String[] cAbb; /*= {"EUR", "GBP", "JPY", "CAD", "RUB"};*/
    static String[] cName; //= {"Euros", "Pounds Sterling", "Yen", "Canadian Dollars", "Russian Rubles"};


    public static void main(String[] args) {
        System.out.println("Welcome to the Foreign Currency program");
        getCurrencies();
        getRates();
        doValuation();
        System.out.println("Thanks for using the Foreign Currency calculator");


    }

    private static void getCurrencies() {
        cRates = new double[5];//Find and get 5 currencies user wants to use .. validate abbreviates as 3 characters.
        cAbb = new String[5];
        cName = new String[5];
        System.out.println("Please enter the names and abbreviations of the currencies you want to use.");
        String menu = "Enter the name of the currency you want to use: ";
        String abbMenu = "Enter the abbreviation you want to use using only 3 letters: ";

        for (int i = 0; i < 5; i++) {
                cName[i] = UserInput.getCurrencyName(menu);
               cAbb[i] = UserInput.getThreeLetterAnswer(abbMenu);

        }




    }

    private static void getRates() {
        System.out.println("Please enter the currency exchange rates per USD:");
//        do {
//            cRates[0] = UserInput.getDouble(cAbb[0] + ": ", 0.0, null);
//            if (cRates[0] == 0.0) {
//                System.out.println("Exchange rates cannot be zero");
//            }
//        } while (cRates[0] == 0.0);
        for (int i = 0; i < 5; i++) {
            do {
                cRates[i] = UserInput.getDouble(cAbb[i] + ": ", 0.0, null);
                if (cRates[i] == 0.0) {
                    System.out.println("Exchange rates cannot be zero");
                }
            } while (cRates[i] == 0.0);
        }

    } // getRates

    private static void doValuation() {
        NumberFormat curr = NumberFormat.getCurrencyInstance();
//        System.out.println("Exchange rates: " + rEUR + ", " + rGBP);
        String menu = "Currency? (1=" + cAbb[0] + ", 2=" + cAbb[1] + ", 3=" + cAbb[2] + ", 4=" + cAbb[3] + ", 5=" + cAbb[4] + ", 9=New Rates, 0=Quit):";
        long qty;
        double cVal = 0, grandTotal = 0;
        int choice;
        long[] units = new long[5];
        double[] cTot = new double[5];
        for (int i = 0; i < 5; i++) {
            units[i] = 0L;
        }
        Arrays.fill(cTot, 0.0);


        choice = (int) UserInput.getLong(menu, 0L, 9L);

        while (choice != 0) {
            cVal = 0.0;
            switch (choice) {
                case 1,2,3,4,5 -> {
                    qty = UserInput.getLong("How many " + cName[choice-1] + " are you buying? ", 0L, null);
                    cVal = qty * cRates[choice-1];
                    System.out.println(qty + " " + cName[choice-1] + " will have a cost of: " + curr.format(cVal));
                    units[choice-1] += qty;
                    cTot[choice-1] += cVal;


                }
//



//                    }

//                    case 1 ->  {
//                    qty = UserInput.getLong("How many Euros are you buying? ", 0L, null);
//                    cVal = qty * cRates[0];
//                    System.out.println(qty + " Euros will have a cost of: " + curr.format(cVal));
//                    units[0] += qty;
//                    cTot[0] += cVal;
//                }
//                case 2 ->  {
//                    qty = UserInput.getLong("How many Pounds Sterling are you buying? ", 0L, null);
//                    cVal = qty * cRates[choice-1];
//                    System.out.println(qty + " Pounds Sterling will have a cost of: " + curr.format(cVal));
//                    units[choice-1] += qty;
//                    cTot[choice-1] += cVal;
//                }
//                case 3 -> {
//                    qty = UserInput.getLong("How many Yenn are you buying? ", 0L, null);
//                    cVal = qty * cRates[choice-1];
//                    System.out.println(qty + " Yenn will have a cost of: " + curr.format(cVal));
//                    units[choice-1] += qty;
//                    cTot[choice-1] += cVal;
//                }
//
//                case 4 -> {
//                    qty = UserInput.getLong("How many Canadian Dollars are you buying? ", 0L, null);
//                    cVal = qty * cRates[choice-1];
//                    System.out.println(qty + " Canadian Dollars will have a cost of: " + curr.format(cVal));
//                    units[choice-1] += qty;
//                    cTot[choice-1] += cVal;
//                }
//                case 5 -> {
//                    qty = UserInput.getLong("How many Russian Rubles are you buying? ", 0L, null);
//                    cVal = qty * cRates[choice-1];
//                    System.out.println(qty + " Russian Rubles will have a cost of: " + curr.format(cVal));
//                    units[choice-1] += qty;
//                    cTot[choice-1] += cVal;
//                }
                    case 6, 7, 8 -> {
                        System.out.println("Unknown operation");
                    }
                    case 9 -> {
                        getRates();
                    }
                    default -> {
                        System.out.println("I cannot process currency " + choice);
                    }
                }// end switch
                grandTotal += cVal;
                choice = (int) UserInput.getLong(menu, 0L, 9L);
            } // end while
            //final version should show currency names not units
//            System.out.println("EUR: " + units[0] + " Euros costing " + curr.format(cTot[0]));
            for (int i = 0; i < 5; i++) {
                System.out.println(cAbb[i] + ": " + units[i] + " " + cName[i] + " costing " + curr.format(cTot[i]));
            }
            System.out.println("You purchased a total of " + curr.format(grandTotal));
        }



}



