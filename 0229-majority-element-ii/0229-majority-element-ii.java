import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        int num1 = 0;
        int num2 = 0;
        int size1 = 0;
        int size2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (size1 > 0 && num1 == nums[i]) {
                size1++;
            } else if (size2 > 0 && num2 == nums[i]) {
                size2++;
            } else if (size1 == 0) {
                num1 = nums[i];
                size1++;
            } else if (size2 == 0) {
                num2 = nums[i];
                size2++;
            } else {
                size1--;
                size2--;
            }
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == num1)
                count1++;
            else if (nums[i] == num2)
                count2++;
        }
        if (count1 > nums.length / 3)
            res.add(num1);
        if (count2 > nums.length / 3)
            res.add(num2);
        return res;
    }
}
