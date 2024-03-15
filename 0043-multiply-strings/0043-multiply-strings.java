public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] arr = new int[m + n];
        Arrays.fill(arr, 0);
        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                arr[i + j + 1] += a * b;
            }
        }
        for (int i = arr.length - 1; i > 0;i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        StringBuilder ans = new StringBuilder();
        int i = arr[0] != 0 ? 0 : 1;
        for (; i < arr.length; i++) {
            ans.append(arr[i]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2));
    }
}
