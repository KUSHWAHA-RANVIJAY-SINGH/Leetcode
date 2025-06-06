class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder sb = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }

        // Convert to long to avoid overflow, and take abs
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        sb.append(num / den);

        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");

        // Map from remainder to the length of the string builder to detect repetition
        Map<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            // If the remainder is seen, we found a repeating cycle
            if (map.containsKey(remainder)) {
                int index = map.get(remainder);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }

            map.put(remainder, sb.length());
            remainder *= 10;
            sb.append(remainder / den);
            remainder %= den;
        }

        return sb.toString();
    }
}