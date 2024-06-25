public class KnapsackSpaceOptimized {
        public static int knapsack(int[] weights, int[] values, int capacity) {
            int n = weights.length;
            int[] dp = new int[capacity + 1];  
            for (int i = 0; i < n; i++) {
                for (int w = capacity; w >= weights[i]; w--) {
                    dp[w] = Math.max(dp[w], values[i] + dp[w - weights[i]]);
                }
            }    
            return dp[capacity];
        }   
        public static void main(String[] args) {
            int[] weights = {1, 3, 4, 5};
            int[] values = {1, 4, 5, 7};
            int capacity = 7;
            System.out.println(knapsack(weights, values, capacity)); // Output: 9
        }
    }

