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
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length<k) return -1;
        int maxi=-1;
        int sum=0;
        
        for(int i: arr){
            maxi = Math.max(maxi,i);
            sum+=i;
        }
        
        int s=maxi;
        int e=sum;
        int ans=-1;
        while(s<=e){
            int mid = s + (e-s)/2; //minP
            int st=1;
            int pages=0;
            for(int i: arr){
                if(pages+i<=mid){
                    pages+=i;
                }
                else{
                    st++;
                    pages=i;
                }
            }
            if(st<=k){ //ans store here
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