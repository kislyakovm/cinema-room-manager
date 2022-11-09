package cinema;

import java.util.Scanner;

public class Cinema {

    public static int rows = 0;
    public static int seatsInRow = 0;
    public static int numberOfPurchasedTickets = 0;
    public static int currentIncome = 0;
    public static int totalIncome = 0;
    public static boolean isExit = false;

    public static void main(String[] args) {

        int action;

        getHallSize();
        calculateTotalIncome();
        char[][] hall = formingEmptyHall();

        while (!isExit) {
            action = printMenuInputAction();
            System.out.println();
            chooseAction(action, hall);
        }
    }


    public static void getHallSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();

        System.out.println("Enter the number of seats in each row:");
        seatsInRow = scanner.nextInt();
    }


    public static void calculateTotalIncome() {
        if (rows * seatsInRow < 60) {
            Cinema.totalIncome = rows * seatsInRow * 10;
        } else {
            Cinema.totalIncome = (((rows / 2 * 10) + ((rows - (rows / 2)) * 8)) * seatsInRow);
        }
    }


    public static void showTheSeats(char[][] hall) {
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
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

        return scanner.nextInt();
    }


    public static void chooseAction(int action, char[][] hall) {
        switch (action) {
            case 1 -> showTheSeats(hall);
            case 2 -> buyTicket(hall);
            case 3 -> showStatistic();
            case 0 -> isExit = true;
        }
    }


    public static void buyTicket(char[][] hall) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a row number:");
        int row = scanner.nextInt();

        System.out.println("Enter a seat number in that row:");
        int seatInRow = scanner.nextInt();

        System.out.println();

        boolean isSeatsOk = checkRowsAndSeats(row, seatInRow, hall);
        if (!isSeatsOk) {
            buyTicket(hall);
            return;
        }

        int ticketPrice = calculateTicketPrice(row);
        currentIncome += ticketPrice;
        numberOfPurchasedTickets++;

        System.out.printf("Ticket price: $%d%n", ticketPrice);
        // seat reservation
        hall[row - 1][seatInRow - 1] = 'B';
    }


    public static int calculateTicketPrice(int row) {
        int ticketPrice;

        if (rows * seatsInRow < 60) ticketPrice = 10;
        else if (rows / 2 >= row) ticketPrice = 10;
        else ticketPrice = 8;

        return ticketPrice;
        }


    public static boolean checkRowsAndSeats(int row, int seatInRow, char[][] hall) {
        if (row > rows || seatInRow > seatsInRow || row < 1 || seatInRow < 1) {
            System.out.println("Wrong input!");
            System.out.println();
            return false;
        } else if (hall[row - 1][seatInRow - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            System.out.println();
            return false;
        }
        return true;
    }


    public static char[][] formingEmptyHall() {
        char[][] hall = new char[rows][seatsInRow];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seatsInRow; j++) {
                hall[i][j] = 'S';
            }
        }
        return hall;
    }


    public static void showStatistic() {
        System.out.printf("Number of purchased tickets: %d%n", numberOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%%n", (double)numberOfPurchasedTickets / (rows * seatsInRow) * 100);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);
    }
}