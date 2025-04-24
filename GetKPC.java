import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GetKPC {
    // Mapping from numbers to corresponding characters (like on a phone keypad)
    static Character[][] numberToCharMap;

    // Recursive function to generate and return all possible words
    private static List<String> printWords(int[] numbers, int len, int numIndex, String s) {
        // Base case: if all digits are processed,, return the current string in a list
        if (len == numIndex) {
            return new ArrayList<>(Collections.singleton(s));
        }
        // List to store all possible words formed so far
        List<String> stringList = new ArrayList<>();

        // Iterate through the characters corresponding to the current digit
        for (int i = 0; i < numberToCharMap[numbers[numIndex]].length; i++) {
            // Make a copy of the current string and add the new character
            String sCopy = String.copyValueOf(s.toCharArray());
            sCopy = sCopy.concat(numberToCharMap[numbers[numIndex]][i].toString());

            // Recursively call for the next digit in the array
            stringList.addAll(printWords(numbers, len, numIndex + 1, sCopy));
        }
        return stringList;

    }

    // Wrapper function to start the recursive function and print the result
    private static void printWords(int[] numbers) {
        generateNumberToCharMap(); // Generate the mapping from digits to characters
        List<String> stringList = printWords(numbers, numbers.length, 0, ""); // Start the recursive process
        stringList.stream().forEach(System.out::println); // Print each generated word
    }

    // Function to generate the mapping of digits to corresponding chracters
    private static void generateNumberToCharMap() {
        numberToCharMap = new Character[10][5]; // Create a map for 10 digits (0-9)

        numberToCharMap[0] = new Character[] { '\0' }; // No characters for '0'
        numberToCharMap[1] = new Character[] { '\0' }; // No characters for '1'
        numberToCharMap[2] = new Character[] { 'a', 'b', 'c' };
        numberToCharMap[3] = new Character[] { 'd', 'e', 'f' };
        numberToCharMap[4] = new Character[] { 'g', 'h', 'i' };
        numberToCharMap[5] = new Character[] { 'j', 'k', 'l' };
        numberToCharMap[6] = new Character[] { 'm', 'n', 'o' };
        numberToCharMap[7] = new Character[] { 'p', 'q', 'r', 's' };
        numberToCharMap[8] = new Character[] { 't', 'u', 'v' };
        numberToCharMap[9] = new Character[] { 'w', 'x', 'y', 'z' };
    }

    // Main method - Entry point of the program
    public static void main(String[] args) {
        // Create a scanner object to read input from the user
        Scanner scn = new Scanner(System.in);

        // Prompt the user to input the number of digits
        System.out.print("Enter the number of digits: ");
        int n = scn.nextInt();

        // Create an array to store the digits
        int[] arr = new int[n];

        // Prompt the user to input the digits
        System.out.println("Enter the digits:");
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // Function call to print all possible words
        printWords(arr);
    }
}
