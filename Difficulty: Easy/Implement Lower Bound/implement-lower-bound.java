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
            int ans = sln.lowerBound(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int lowerBound(int[] nums, int x) {
        // code here
        int n=nums.length;
        int s=0,e=n-1;

        int idx=n; //ans;

        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m]<x){
                s=m+1;
            }
            else if(nums[m]>=x){ //ans will be here
                idx = Math.min(idx,m);
                e=m-1;
            }
        }

        return idx;
    }
}
