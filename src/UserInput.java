import java.util.Scanner;

public class UserInput {

    public static long getLong(String prompt, Long floor, Long ceiling) {
        long val = 0;
        Scanner sc = new Scanner(System.in);
        boolean goodVal = false; // control loop
        do {
            try {
                System.out.print(prompt);
                val = Long.parseLong(sc.nextLine());
                if (floor != null && val < floor) {
                    System.out.println("Your answer " + val + " is below the floor of " + floor);
                    goodVal = false;
                }
                else if (ceiling != null && val > ceiling) {
                    System.out.println("Your answer " + val + " is above the ceiling of " + ceiling);
                    goodVal = false;
                }
                else {
                    goodVal = true;
                }
            } catch (Exception e) {
                System.out.println("Illegal input: " + e.getMessage());
                goodVal = false;
            }

        } while (!goodVal);

        return val;
    }

    public static double getDouble(String prompt, Double floor, Double ceiling){
        double val = 0;
        Scanner sc = new Scanner(System.in);
        boolean goodVal = false; // control loop
        do {
            try {
                System.out.print(prompt);
                val = Double.parseDouble(sc.nextLine());
                if (floor != null && val < floor) {
                    System.out.println("Your answer " + val + " is below the floor of " + floor);
                    goodVal = false;
                }
                else if (ceiling != null && val > ceiling) {
                    System.out.println("Your answer " + val + " is above the ceiling of " + ceiling);
                    goodVal = false;
                }
                else {
                    goodVal = true;
                }
            } catch (Exception e) {
                System.out.println("Illegal input: " + e.getMessage());
                goodVal = false;
            }

        } while (!goodVal);
        return val;

    }

    public static String getYNAnswer(String prompt){
        String ans;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print(prompt);
            ans = sc.nextLine();
            if (!ans.equalsIgnoreCase("Y") &&
                    !ans.equalsIgnoreCase("YES") &&
                    !ans.equalsIgnoreCase("N") &&
                    !ans.equalsIgnoreCase("NO")) {
                System.out.println("I do not understand your answer. Please answer Yes or No (Y/N)");
            }
        } while (!ans.equalsIgnoreCase("Y") &&
                !ans.equalsIgnoreCase("YES") &&
                !ans.equalsIgnoreCase("N") &&
                !ans.equalsIgnoreCase("NO"));
        return ans;
        }

    public static String getCurrencyName(String prompt){
        String ans = "";
        Scanner sc = new Scanner(System.in);
        boolean isString = true;
        do {
            try{
               
                System.out.print(prompt);
                ans = sc.nextLine();
                if (ans.matches("[a-zA-Z]+")){
                    isString = true;
                    return ans;
                }
                else {
                    isString = false;
                }
            }
            catch (Exception e){
                System.out.println("Illegal output, currency name must not contain numbers or characters.");

            }
        } while (!isString);
        
        return ans;
        
    }

    public static String getThreeLetterAnswer(String prompt) {
        String ans = "";
        Scanner sc = new Scanner(System.in);
        try {

            System.out.print(prompt);
            ans = sc.nextLine();
            while (!ans.toUpperCase().contains(ans) ){
                System.out.println("Abbreviations must be capitalized");
                System.out.print(prompt);
                ans = sc.nextLine();
            }
            while (ans.length() != 3 || !ans.matches("[a-zA-Z]+")) {
                System.out.println("Abbreviations must be 3 letters long and can only contain letters");
                System.out.print(prompt);
                ans = sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println("Illegal output for currency abbreviation");
        }
        return ans;
    }
    }


