class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //Brute Froce solution
        // int n = matrix.length, m= matrix[0].length;

        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(matrix[i][j] == target){
        //             return true ;
        //         }
        //     }
        // }
        // return false;

        //Better Sol^n
        int n =matrix.length;
        int m =matrix[0].length;
        int low =0 ,high = n*m-1;
        while(low<=high){
            int mid = (low+high)/2;
            int midElement = matrix[mid / m][mid % m];
            if(midElement==target){
                return true;
            }else if(target>midElement){
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return false;
    }
}