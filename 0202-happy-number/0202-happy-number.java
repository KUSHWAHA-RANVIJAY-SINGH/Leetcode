class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = squaredSum(slow);
            fast = squaredSum(squaredSum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int squaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        return sum;
    }
}
