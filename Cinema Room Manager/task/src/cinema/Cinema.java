package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isExit = false;
        int action;

        // read rows and seats
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();

        char[][] hall = formingEmptyHall(rows, seatsInRow);

        while (!isExit) {
            action = printMenuInputAction();
            isExit = chooseAction(action, isExit, rows, seatsInRow, hall);
        }
    }

    public static void showTheSeats(int rows, int seatsInRow, char[][] hall) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");

        for (int k = 1; k <= seatsInRow; k++) System.out.print(" " + k);
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < seatsInRow; j++) {
                System.out.print(" " + hall[i][j]);
            }
            System.out.println();
        }
    }

    public static int printMenuInputAction() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");

        return scanner.nextInt();
    }

    public static boolean chooseAction(int action, boolean isExit, int rows, int seatsInRow, char[][] hall) {
        switch (action) {
            case 1 -> showTheSeats(rows, seatsInRow, hall);
            case 2 -> buyTicket(rows, seatsInRow, hall);
            case 0 -> isExit = true;
        }
        return isExit;
    }

    public static void buyTicket(int rows, int seatsInRow, char[][] hall) {
        Scanner scanner = new Scanner(System.in);
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
    }

    public static char[][] formingEmptyHall(int rows, int seatsInRow) {
        char[][] hall = new char[rows][seatsInRow];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                hall[i][j] = 'S';
            }
        }
        return hall;
    }
}