//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int a;
            a = Integer.parseInt(br.readLine());

            int b;
            b = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int[] ans = obj.lcmAndGcd(a, b);
            System.out.println(ans[0] + " " + ans[1]);
            System.out.println("~");
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int[] lcmAndGcd(int a, int b) {
        // code here
        //lcm*gcd = a*b
        
        int maxi = Math.max(a,b);
        int mini = Math.min(a,b);
        int lcm=0;
        for(int i=maxi;;i+=maxi){
            if(i%mini==0){
                lcm=i;
                break;
            }
        }
        
        int gcd = (a*b)/lcm;
        
        int[] ans = {lcm,gcd};
        return ans;
    }
}


//{ Driver Code Starts.

// } Driver Code Ends