import java.util.Scanner;
// this progeram is part of a video game ranking system
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dreamScape;
        String choice = "";
        int dreamNum;
        boolean run = false;

        while ( run = true ) {
            System.out.println("enter the location you started in");
            dreamScape = scanner.nextLine();
            System.out.println("enter number of dreams you had");
            dreamNum = Integer.parseInt(scanner.nextLine());

            DreamerSlept dreamerSlept = new DreamerSlept(dreamNum, dreamScape);
            System.out.println("The number of dreams you had was: " + dreamNum);
            System.out.println("You are part of the: " + dreamScape);
            System.out.printf("You gained the: %s%n", DreamerSlept.dreamRank(dreamNum, dreamScape));

            System.out.println("Would you like to continue? (enter yes)");
            choice = scanner.nextLine();

            if (choice == "y") {
                System.out.println("enter the location you started in");
                dreamScape = scanner.nextLine();
                System.out.println("enter number of dreams you had");
                dreamNum = Integer.parseInt(scanner.nextLine());

                dreamerSlept = new DreamerSlept(dreamNum, dreamScape);
                System.out.println("The number of dreams you had was: " + dreamNum);
                System.out.println("You are part of the: " + dreamScape);
                System.out.printf("You gained the: %s%n", DreamerSlept.dreamRank(dreamNum, dreamScape));
            } else{
                run=false;
            }
        }
    }
}
