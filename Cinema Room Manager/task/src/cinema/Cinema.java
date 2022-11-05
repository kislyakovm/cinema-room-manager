package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();

        int profit = 0;

        if (rows * seatsInRow < 60) {
            profit = rows * seatsInRow * 10;
        } else {
            profit = (((rows / 2) * 10) + ((rows - (rows / 2)) * 8)) * seatsInRow;
        }

        System.out.println("Total income:");
        System.out.println("$" + profit);
    }
}