import java.util.Scanner;


public class Series extends SeriesModel{
    public Series( String SeriesId, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes){
        super(SeriesId,  SeriesName, SeriesAge, SeriesNumberOfEpisodes);
    }


    public static String captureSeries(){ // This captures the series
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String age = "";
        String episodeNum = "";
        int ageNum;
        System.out.println("CAPTURING NEW SERIES" ) ;
        System.out.println("*********************************************");
        System.out.println("Enter the series ID");
        id = scanner.nextLine();
        System.out.println("Enter the series name");
        name= scanner.nextLine();
            while (true) {
            System.out.println("Enter the series age restriction (digits only, between 2 and 18):");
            age = scanner.nextLine();

            if (age.matches("\\d+")) {
                ageNum = Integer.parseInt(age);
                if (ageNum >= 2 && ageNum <= 18) {
                    System.out.println("Age restriction captured successfully.");
                    break;
                } else {
                    System.out.println("You have entered the incorrect series age. The age restriction must be between 2 and 18.");
                }
            } else {
                System.out.println("You have entered the incorrect series age. Only digits are allowed.");
            }
        }
        System.out.println("Enter the series number of episodes");
        episodeNum = scanner.nextLine();
        Series newSeries = new Series( id, name, age,episodeNum );
        seriesList.add(newSeries);
        System.out.println("Series successfully stored.");
        return id;
    }


    public static void searchSeries() { // this method was created through chatGPT
        Scanner scanner = new Scanner(System.in);
        System.out.println("SERIES SEARCH");
        System.out.println("*******************************");
        System.out.println("Enter the series ID to search for:");
        String searchId = scanner.nextLine();
        System.out.println("Searching for a series ");
        boolean foundIt = false;

        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(searchId)) {
                System.out.println("Series Found:");
                System.out.println("ID: " + s.getSeriesId());
                System.out.println("Name: " + s.getSeriesName());
                System.out.println("Age Restriction: " + s.getSeriesAge());
                System.out.println("Number of Episodes: " + s.getSeriesNumberOfEpisodes());
                foundIt = true;
            }
        }

        if (!foundIt) {
            System.out.println("Series not found");
        }
    }


    public static void UpdateSeries() { // this method updates series information after the series ID has been entered
        Scanner scanner = new Scanner(System.in);
        String id;
        String name;
        String age = "";
        int ageNum;
        String episodeNum;
        boolean foundIt = false;
        System.out.println("UPDATE SERIES");
        System.out.println("*******************************");

        System.out.println("Enter the Series ID you want to update:");
        id = scanner.nextLine();
        for (SeriesModel s : seriesList) {
            if (s.getSeriesId().equalsIgnoreCase(id)) {
                foundIt = true;
                System.out.println("Enter the updated series name:");
                name = scanner.nextLine();
                s.SeriesName = name;
                System.out.println("Series name updated successfully.");
                while (true) {
                    System.out.println("Enter the updated series age restriction (digits only, between 2 and 18):");
                    age = scanner.nextLine();
                    if (age.matches("\\d+")) {
                        ageNum = Integer.parseInt(age);
                        if (ageNum >= 2 && ageNum <= 18) {
                            s.SeriesAge = age;
                            System.out.println("Age restriction updated successfully.");
                            break;
                        } else {
                            System.out.println("You have entered the incorrect series age. The age restriction must be between 2 and 18.");
                        }
                    } else {
                        System.out.println("You have entered the incorrect series age. Only digits are allowed.");
                    }
                }
                System.out.println("Enter the updated number of episodes:");
               episodeNum = scanner.nextLine();
                s.SeriesNumberOfEpisodes = episodeNum;
                System.out.println("Number of episodes updated successfully .");
            }
        }

        if (!foundIt) {
            System.out.println("Series with ID " + id + " not found.");
        }
    }




    public static void deleteSeries(){ // this method deletes the series
        Scanner scanner = new Scanner(System.in);
        String id;
        String choice;
        boolean found = false;
        System.out.println("SERIES DElETION");
        System.out.println("*******************************");
        System.out.println("Enter the series ID of the series you want to delete");
        id = scanner.nextLine();
        System.out.println("Are you sure you want to delete series with ID \"" + id + "\"? Type Y to confirm.");
        choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("y")){
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesId().equalsIgnoreCase(id)) {
                seriesList.remove(i);
                System.out.println("Series" + id + "successfully deleted.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Series with ID " + id + " not found.");
            }
        } else {
            System.out.println("Canceled series deletion.");
        }
    }

    public static void displaySeries() { // this displays the full report of the series
        System.out.println("SERIES REPORT");
        System.out.println("*******************************");
        if (seriesList.isEmpty()) {
            System.out.println("No series available.");
            return;
        }

        for (SeriesModel s : seriesList) {
            System.out.println("----------------------------");
            System.out.println("Id: " + s.getSeriesId());
            System.out.println("----------------------------");
            System.out.println("Name: " + s.getSeriesName());
            System.out.println("Age: " + s.getSeriesAge());
            System.out.println("Episodes: " + s.getSeriesNumberOfEpisodes());
            System.out.println("----------------------------");
        }
    }
}


