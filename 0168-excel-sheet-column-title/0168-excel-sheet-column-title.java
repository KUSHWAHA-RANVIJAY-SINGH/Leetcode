class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
        int remainder = columnNumber % 26;
        char ch = (char) (remainder + 'A');
        sb.append(ch);
        columnNumber /= 26;
        }
       return sb.reverse().toString();
    }
}