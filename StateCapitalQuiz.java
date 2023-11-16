import java.util.*;

public class StateCapitalQuiz {
    public static void main(String[] args) {
        // Part 1: Sorting Arrays
        String[][] stateCapitals = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "St. Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        // Sort the array by capital using bubble sort
        bubbleSortByCapital(stateCapitals);

        // Quiz the user on state capitals
        int correctCount = 0;
        Scanner scanner = new Scanner(System.in);

        for (String[] pair : stateCapitals) {
            System.out.print("What is the capital of " + pair[0] + "? ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();
            if (userAnswer.equals(pair[1].toLowerCase())) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. The capital is " + pair[1] + ".");
            }
        }

        System.out.println("Total Correct Answers: " + correctCount);

        // Part 2: Sorting & Searching (HashMap)
        Map<String, String> stateCapitalMap = new HashMap<>();

        for (String[] pair : stateCapitals) {
            stateCapitalMap.put(pair[0], pair[1]);
        }

        // Sort the map by state using a (TreeMap)
        TreeMap<String, String> sortedStateCapitalMap = new TreeMap<>(stateCapitalMap);

        // Display the sorted map
        System.out.println("\nState-Capital Map (Sorted by State):");
        for (Map.Entry<String, String> entry : sortedStateCapitalMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Prompt the user to enter a state and display the capital
        System.out.print("\nEnter a state to get its capital: ");
        String userState = scanner.nextLine().trim();

        if (sortedStateCapitalMap.containsKey(userState)) {
            String capital = sortedStateCapitalMap.get(userState);
            System.out.println("The capital of " + userState + " is " + capital);
        } else {
            System.out.println("State not found in the map.");
        }

        scanner.close();
    }

    // Bubble sort the 2D array by the capital (second column)
    private static void bubbleSortByCapital(String[][] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j][1].compareToIgnoreCase(array[j + 1][1]) > 0) {
                    // Swap array[j] and array[j + 1]
                    String[] temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
