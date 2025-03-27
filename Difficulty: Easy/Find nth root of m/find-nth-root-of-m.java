//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int m = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthRoot(n, m);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int myPow(int x, int n){
        int ans=1;
        
        while(n>0){
            if(n%2==0){
                n=n/2;
                x=x*x;
            }
            else{
                n--;
                ans=ans*x;
            }
        }
        return ans;
    }
    public int nthRoot(int n, int m) {
        // code here
        int s=1;
        int e=m;
        
        //T.C: O(logM * logN)
        
        while(s<=e){
            int mid = s + (e-s)/2;
            int val = myPow(mid,n);
            if(val==m){
                return mid; 
            }
            else if(val > m){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        
        return -1;
    }
}