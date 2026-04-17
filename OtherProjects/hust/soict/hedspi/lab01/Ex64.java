package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class Ex64 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = 0;
        int year = -1;

        while (true) {
            System.out.print("Enter month: ");
            String input = sc.nextLine();

            month = getMonth(input);

            if (month != -1)
                break;
            System.out.println("Invalid month, please enter again!");
        }

        while (true) {
            System.out.print("Enter year: ");
            String input = sc.nextLine();

            try {
                year = Integer.parseInt(input);
                if (year >= 0)
                    break;
            } catch (Exception e) {
            }

            System.out.println("Invalid year, please enter again!");
        }

        boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        int days = 0;

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30;
                break;
            case 2:
                days = isLeap ? 29 : 28;
                break;
        }

        System.out.println("Number of days: " + days);

        sc.close();
    }

    public static int getMonth(String m) {
        switch (m) {
            case "January":
            case "Jan":
            case "Jan.":
            case "1":
                return 1;
            case "February":
            case "Feb":
            case "Feb.":
            case "2":
                return 2;
            case "March":
            case "Mar":
            case "Mar.":
            case "3":
                return 3;
            case "April":
            case "Apr":
            case "Apr.":
            case "4":
                return 4;
            case "May":
            case "May.":
            case "5":
                return 5;
            case "June":
            case "Jun":
            case "Jun.":
            case "6":
                return 6;
            case "July":
            case "Jul":
            case "Jul.":
            case "7":
                return 7;
            case "August":
            case "Aug":
            case "Aug.":
            case "8":
                return 8;
            case "September":
            case "Sep":
            case "Sept.":
            case "9":
                return 9;
            case "October":
            case "Oct":
            case "Oct.":
            case "10":
                return 10;
            case "November":
            case "Nov":
            case "Nov.":
            case "11":
                return 11;
            case "December":
            case "Dec":
            case "Dec.":
            case "12":
                return 12;
            default:
                return -1;
        }
    }
}