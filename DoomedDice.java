
import java.util.HashMap;
import java.util.Map;

public class DoomedDice {
    
    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};
        
        // Transform the dice
        int[] newDieA = {1, 2, 2, 3, 3, 4};
        int[] newDieB = {3, 4, 5, 6, 7, 8};
        
        System.out.println("New Die A: ");
        printArray(newDieA);
        System.out.println("New Die B: ");
        printArray(newDieB);
        
        // Verify probability remains the same
        System.out.println("\nOriginal Probability Distribution:");
        printProbabilityDistribution(dieA, dieB);
        
        System.out.println("\nNew Probability Distribution:");
        printProbabilityDistribution(newDieA, newDieB);
    }
    
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printProbabilityDistribution(int[] dieA, int[] dieB) {
        Map<Integer, Integer> sumCount = new HashMap<>();
        int totalCombinations = dieA.length * dieB.length;

        // Count occurrences of each sum
        for (int a : dieA) {
            for (int b : dieB) {
                int sum = a + b;
                sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
            }
        }

        // Print probabilities
        for (int sum = 2; sum <= 12; sum++) {
            double probability = (double) sumCount.getOrDefault(sum, 0) / totalCombinations;
            System.out.printf("P(Sum = %d) = %.4f\n", sum, probability);
        }
    }
}

