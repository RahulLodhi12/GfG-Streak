//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.smallestDivisor(a, k);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int smallestDivisor(int[] nums, int k) {
        // code here
         //search space : [1,dmax]
        int dmax=Integer.MIN_VALUE;

        for(int i: nums){
            dmax = Math.max(dmax,i);
        }
        
        int s = 1;
        int e = dmax;
        int ans=-1;
        while(s<=e){
            int mid = s + (e-s)/2; //d
            int sum=0;
            for(int i: nums){
                sum+=Math.ceil((double)i/mid);
            }
            if(sum<=k){ //ans is store
                ans = mid;
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return ans;
    }
}