public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) return false;

        int[] primes = {2, 3, 5};

        for (int prime : primes) {
            while (num % prime == 0) {
                num /= prime;
            }
        }

        return num == 1;
    }
}