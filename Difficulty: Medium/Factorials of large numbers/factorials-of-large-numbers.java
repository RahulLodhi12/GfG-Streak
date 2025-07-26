// User function Template for Java

class Solution {
    public static void reverse(int i, int j, ArrayList<Integer> ans){
        while(i<j){
            Collections.swap(ans,i,j);
            i++;
            j--;
        }
    }
    public static ArrayList<Integer> factorial(int n) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        
        int size=1;
        for(int i=2;i<=n;i++){
            int carry=0;
            for(int j=0;j<size;j++){
                int res = i*ans.get(j)+carry;
                
                ans.set(j,res%10);
                carry = res/10;
            }
            while(carry>0){
                ans.add(carry%10);
                size++;
                carry=carry/10;
            }
        }
        
        reverse(0,ans.size()-1,ans);
        
        return ans;
    }
}