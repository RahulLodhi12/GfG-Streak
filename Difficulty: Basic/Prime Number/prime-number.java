//{ Driver Code Starts


import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            if (ob.isPrime(n)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static boolean isPrime(int n) {
        // code here
        if(n==1) return false;
        if(n==2 || n==3) return true;
        if(n%2==0 || n%3==0) return false;
        
        for(int i=5;i<=Math.sqrt(n);i+=6){
            if(n%i==0 || n%(i+2)==0) return false;
        }
        
        return true;
    }
}