//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String s[] = sc.nextLine().split(" ");
            int n = s.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);
            int m = Integer.parseInt(sc.nextLine());
            int k = Integer.parseInt(sc.nextLine());
            Solution obj = new Solution();
            int res = obj.minDaysBloom(m, k, arr);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int minDaysBloom(int m, int k, int[] bloomDay) {
        // code here
        int dmin=Integer.MAX_VALUE;
        int dmax=Integer.MIN_VALUE;

        for(int i: bloomDay){
            dmin = Math.min(i,dmin);
            dmax = Math.max(i,dmax);
        }

        int s=dmin,e=dmax;
        int ans=-1;

        while(s<=e){
            int mid = s + (e-s)/2; //d
            int b=0;
            int cnt=0;
            for(int i: bloomDay){
                if(i<=mid){
                    cnt++;
                }
                else{
                    cnt=0;
                }

                if(cnt==k){
                    b++;
                    cnt=0;
                }
            }
            if(b>=m){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return ans;
    }
}