class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null){
            return 0;
        }
        int ans=0;
        String str=s.trim();
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)!=' '){
                ans++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}
