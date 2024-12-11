import java.util.Scanner;

public class case_std {
    

    public static void main(String[] args) {
        String[][] achievements = new String[15][5]; 
        int numData = 0; 
        Scanner sc = new Scanner(System.in); 
        while (true) {
            System.out.println("=== RECORDING STUDENT ACHIEVEMENT ===");
            System.out.println("1. Add Achievement");
            System.out.println("2. Display Achievements");
            System.out.println("3. Achievement Analysis by Type");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                addingAchievement(achievements, numData);
                numData++;
                continue;
            }
            else if (choice == 2) {
                displayingLists(achievements, numData);
                continue;
            }
            else if (choice == 3) {
                analyzingAchievement(achievements, numData);;
                continue;
            }
            else if (choice == 4) {
                System.out.println("Program completed. Thank you");
                break;
            }
            else {
                System.out.println("Incorrect number please choose a number between (1-4).");
                continue;
            }
        }
    }

    public static void addingAchievement(String[][] achievements, int numData) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        achievements[numData][0] = sc.nextLine();
        System.out.print("Enter NIM: ");
        achievements[numData][1] = sc.nextLine();
        System.out.print("Enter Type of Achievement (1st/2nd/3rd): ");
        achievements[numData][2] = sc.nextLine();

        while (true) {
            System.out.print("Enter Level of Achievement (Local, National, International): ");
            achievements[numData][3] = sc.nextLine();
            if (achievements[numData][3].equalsIgnoreCase("Local") || 
                achievements[numData][3].equalsIgnoreCase("National") || 
                achievements[numData][3].equalsIgnoreCase("International")) {
                break;
            } else {
                System.out.println("Invalid level! Please enter Local, National, or International.");
                continue;
            }
        }
        while (true) {
        System.out.print("Enter Year of Achievement (2010 - 2024): ");
        int years = sc.nextInt();
        sc.nextLine();
            if (years >= 2010 && years <= 2024) {
                String year = Integer.toString(years);
                achievements[numData][4] = year;
                break;
            } else {
                System.out.println("Invalid year! Please enter a year between (2010 - 2024).");
                continue;
            }
        }
        System.out.println("Achievement added successfully!");
        System.out.println();
    }
    public static void displayingLists(String[][] achievements, int numData) {
        Scanner sc = new Scanner(System.in);
            if (numData == 0) {
                System.out.println("No achievements recorded.");
            } else {
                System.out.println("\n=== LIST OF ALL ACHIEVEMENT ===");
                for (int i = 0; i < numData; i++) {
                    for (int j = 0; j < achievements[i].length; j++) {
                        if (j == 0) System.out.print("Name: " + achievements[i][j] + " | ");
                        else if (j == 1) System.out.print("NIM: " + achievements[i][j] + " | ");
                        else if (j == 2) System.out.print("Achievement: " + achievements[i][j] + " | ");
                        else if (j == 3) System.out.print("Level: " + achievements[i][j] + " | ");
                        else if (j == 4) System.out.print("Year: " + achievements[i][j]);
                    }
                    System.out.println(); 
                }
            }
            System.out.print("Do you want to display achievement by type and year (y/n)?: ");
            String conf = sc.nextLine();
            if (conf.equalsIgnoreCase("y")) {
                System.out.print("Enter the achievement by type: ");
                String type = sc.nextLine();
                System.out.print("Enter year: ");
                String year = sc.nextLine();
                boolean found=false;
                for(int i = 0; i < numData; i++){
                    if(achievements[i][2].equalsIgnoreCase(type)){
                        if(achievements[i][4].equalsIgnoreCase(year) ){
                            found = true;
                            System.out.println("Student Name: " + achievements[i][0] +
                                                " | NIM: " + achievements[i][1] +
                                                " | Achievement: " + achievements[i][2] +
                                                " | Level: " + achievements[i][3] +
                                                " | Year: " + achievements[i][4]);
                        }
                    }
                }
                if (!found) {
                System.out.println("Not Found");
                }
            }
        System.out.println();
    }
    static void analyzingAchievement(String[][] achievements, int numData) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the type or years of achievement you want to analyze: ");
        String type = sc.nextLine();
        boolean found = false;
        System.out.println("\n=== ACHIEVEMENT ANALYSIS ===");
        for (int i = 0; i < numData; i++) {
            if (achievements[i][2].equalsIgnoreCase(type)) {
                found = true;
                System.out.println("Student Name: " + achievements[i][0] +
                                   " | NIM: " + achievements[i][1] +
                                   " | Level: " + achievements[i][3] +
                                   " | Year: " + achievements[i][4]);
            }else if(achievements[i][4].equalsIgnoreCase(type)){
                found = true;
                System.out.println("Student Name: " + achievements[i][0] +
                                   " | NIM: " + achievements[i][1] +
                                   " | Level: " + achievements[i][3] +
                                   " | Year: " + achievements[i][4]);
            }
        }if (!found) {
        System.out.println("No achievements by type: " + type );
        }
        System.out.println();
    }
}