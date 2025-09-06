import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        int choice;
        int option = 0;

        System.out.println("LATEST SERIES - 2025");
        System.out.println("*******************************");
        System.out.println("Enter (1) to launch the menu or any other key to exit:");
        choice = Integer.parseInt(scanner.nextLine());

        while (running) {

            if (choice == 1) {
                System.out.println("Please select one of the following menu options (1-6)");
                System.out.println("1. Capture new series");
                System.out.println("2. Search for a series");
                System.out.println("3. Update age restriction");
                System.out.println("4. Delete a series ");
                System.out.println("5. Print Series report");
                System.out.println("6. Exit Application");

                option = Integer.parseInt(scanner.nextLine());

            } else {
                System.out.println("Quitting... Goodbye!");
                running = false;
            }

            switch (option) {

                case 1: // done

                    Series. captureSeries();
                    break;

                case 2: // done
                    Series.searchSeries();
                    break;

                case 3: // done
                    Series.UpdateSeries();
                    break;

                case 4: // done
                    Series.deleteSeries();
                    break;


                case 5: //done
                    System.out.println("Print Series report");
                    Series.displaySeries();
                    break;

                case 6: //done
                    System.out.println("Exit Application");
                    System.out.println("Quitting... Goodbye!");
                    running = false;

            }
        }
    }









}