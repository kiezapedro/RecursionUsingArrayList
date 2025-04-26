import java.util.Scanner;
import java.util.ArrayList;

public class StairPathFun {

    // Recursive function to print all paths
    public static void printPaths(int n, ArrayList<Integer> path) {
        if (n < 0) return; // invalid path
        if (n == 0) {
            // Reached the top – print the path
            System.out.println(path);
            return;
        }

        // Try step of 1
        path.add(1);
        printPaths(n - 1, path);
        path.remove(path.size() - 1);

        // Try step of 2
        path.add(2);
        printPaths(n - 2, path);
        path.remove(path.size() - 1);

        // Try step of 3
        path.add(3);
        printPaths(n - 3, path);
        path.remove(path.size() - 1);
    }

    // Count the number of ways (optional)
    public static int countWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Input
        System.out.print("Enter number of stairs: ");
        int n = scn.nextInt();

        System.out.println("All paths to climb " + n + " stairs:");
        printPaths(n, new ArrayList<>());

        System.out.println("Total number of ways: " + countWays(n));
    }
}
