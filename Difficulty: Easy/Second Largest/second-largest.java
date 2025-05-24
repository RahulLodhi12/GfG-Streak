class Solution {
    public int getSecondLargest(int[] arr) {
        // code here
        int large=-1;
        for(int i: arr){
            large = Math.max(large,i);
        }

        int secLarge=-1;
        for(int i: arr){
            if(i!=large){
                secLarge=Math.max(secLarge,i);
            }
        }
        return secLarge;
    }
}