class Solution {
    public int smallestEvenMultiple(int n) {
         int r=2*n;
        for(int i=2*n;i>=n;i--)
        {
            if(i%n==0&&i%2==0)
                r=i;
        }
        return r;
    }

}