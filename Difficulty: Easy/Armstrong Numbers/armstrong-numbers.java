//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            boolean flag = ob.armstrongNumber(n);
            if (flag) {
                System.out.println("true");

            } else {
                System.out.println("false");
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int cnt=0;
        int num=n;
        while(n!=0){
            int d=n%10;
            cnt++;
            n=n/10;
        }
        
        int nn=num;
        int sum=0;
        while(num!=0){
            int d=num%10;
            sum+=(int)Math.pow(d,cnt);
            // System.out.println(sum);
            num=num/10;
        }
        
        return nn==sum;
    }
}