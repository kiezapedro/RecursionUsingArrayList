import java.util.*;

public class GetSubsequence {

    // Recursive function to print all possible subsequences for a given array
    public static void printSubsequences(int[] arr, int index, ArrayList<Integer> path) {
        // Print the subsequence when reaching the leaf of the recursion tree
        if (index == arr.length) {
            // Condition to avoid printing an empty subsequence
            if (path.size() > 0) {
                System.out.println(path);
            }
        } else {
            // Subsequence without including the element at the current index
            printSubsequences(arr, index + 1, path);

            // Include the element at the current index in the subsequence
            path.add(arr[index]);

            // Subsequence including the element at the current index
            printSubsequences(arr, index + 1, path);

            // Backtrack to remove the recently added element
            path.remove(path.size() - 1);
        }
    }

    // Main method - Entry point of the program
    public static void main(String[] args) {
        // Define the array for which subsequences are to be printed
        int[] arr = { 1, 2, 3};

        // Create an auxiliary space to store each path(subsequence)
        ArrayList<Integer> path = new ArrayList<>();

        // Call the method to print all subsequences
        printSubsequences(arr, 0, path);
    }
}