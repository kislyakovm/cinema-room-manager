package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();

        int[][] hall = new int[rows][seatsInRow];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                hall[i][j] = 'S';
            }
        }

        //print hall
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int k = 1; k <= seatsInRow; k++) System.out.print(" " + k);
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seatsInRow; j++) {
                System.out.print(" " + (char)hall[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatInRow = scanner.nextInt();

        System.out.println();

        if (rows * seatsInRow < 60) {
            System.out.println("Ticket price: $10");
        } else {
            System.out.println(row <= rows / 2 ? "Ticket price: $10" : "Ticket price: $8");
        }

        // seat reservation
        hall[row - 1][seatInRow - 1] = 'B';

        // print hall
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int k = 1; k <= seatsInRow; k++) System.out.print(" " + k);
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seatsInRow; j++) {
                System.out.print(" " + (char)hall[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }
}