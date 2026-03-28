import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int month = 0;
        int year;

        // nhập month
        while (month == 0) {

            System.out.print("Enter month: ");
            String m = input.nextLine().toLowerCase();

            switch (m) {
                case "1":
                case "jan":
                case "jan.":
                case "january":
                    month = 1;
                    break;

                case "2":
                case "feb":
                case "feb.":
                case "february":
                    month = 2;
                    break;

                case "3":
                case "mar":
                case "mar.":
                case "march":
                    month = 3;
                    break;

                case "4":
                case "apr":
                case "apr.":
                case "april":
                    month = 4;
                    break;

                case "5":
                case "may":
                    month = 5;
                    break;

                case "6":
                case "jun":
                case "june":
                    month = 6;
                    break;

                case "7":
                case "jul":
                case "july":
                    month = 7;
                    break;

                case "8":
                case "aug":
                case "august":
                    month = 8;
                    break;

                case "9":
                case "sep":
                case "sept":
                case "september":
                    month = 9;
                    break;

                case "10":
                case "oct":
                case "october":
                    month = 10;
                    break;

                case "11":
                case "nov":
                case "november":
                    month = 11;
                    break;

                case "12":
                case "dec":
                case "december":
                    month = 12;
                    break;

                default:
                    System.out.println("Invalid month. Enter again.");
            }
        }

        // nhập year
        while (true) {
            System.out.print("Enter year: ");
            year = input.nextInt();

            if (year >= 0) {
                break;
            } else {
                System.out.println("Invalid year. Enter again.");
            }
        }

        boolean leapYear = false;

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            leapYear = true;
        }

        int days = 0;

        switch (month) {

            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                days = 31;
                break;

            case 4: case 6: case 9: case 11:
                days = 30;
                break;

            case 2:
                if (leapYear) {
                    days = 29;
                } else {
                    days = 28;
                }
        }

        System.out.println("Month " + month + " in year " + year + " has " + days + " days.");
    }
}