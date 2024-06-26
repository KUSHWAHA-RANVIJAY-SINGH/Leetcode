import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] temp = score.clone();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            map.put(temp[i], temp.length - i);
        }
        String[] res = new String[score.length];
        for (int i = 0; i < res.length; i++) {
            int rank = map.get(score[i]);
            String rankstr = String.valueOf(rank);
            if (rank == 1) {
                res[i] = "Gold Medal";
            } else if (rank == 2) {
                res[i] = "Silver Medal";
            } else if (rank == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = rankstr;
            }
        }
        return res;
    }
}
