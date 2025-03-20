class Solution {
    public void sortColors(int[] nums) {
        // int n = nums.length;
        // int [] count = new int[3];

        // for(int num : nums){
        //     count[num]++;
        // }
        
        // int index = 0;
        // for(int i=0;i<count[0];i++){
        //     nums[index++] =0;
        // }
        // for(int i=0;i<count[1];i++){
        //     nums[index++] =1;
        // }
        // for(int i=0;i<count[2];i++){
        //     nums[index++] =2;
        // }   //Brute Froce Solution 

        int low =0 ,mid =0, high = nums.length -1;
        while(mid <= high){
            if(nums[mid]==0){
                swap(nums,low++,mid++);
            }else if(nums[mid] ==1){
                mid++;
            }else{
                swap(nums,mid,high--);
            }
        }
       
    }
     private void swap(int[] nums,int i,int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
}