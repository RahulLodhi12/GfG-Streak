//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int evenlyDivides(int n) {
        // code here
        int cnt=0;
        int num = n;
        while(n!=0){
            int d=n%10;
            if(d!=0 && num%d==0){
                cnt++;
            }
            n=n/10;
        }
        return cnt;
    }
}