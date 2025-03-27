//{ Driver Code Starts
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // test cases

        Solution ob = new Solution();

        while (T-- > 0) {
            int n = sc.nextInt(); // input N
            int ans = ob.reverseExponentiation(n);
            System.out.println(ans);
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int reverse(int n){
        int rev=0;
        while(n>0){
            int d=n%10;
            rev=rev*10 + d;
            n=n/10;
        }
        return rev;
    }
    public int reverseExponentiation(int x) {
        // code here
        int ans=1;
        
        int n = reverse(x); //power
        
        while(n>0){
            if(n%2==0){
                n=n/2;
                x=x*x;
            }
            else{
                ans=ans*x;
                n--;
            }
        }
        
        return ans;
    }
}
