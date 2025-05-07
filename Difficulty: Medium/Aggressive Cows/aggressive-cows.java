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
            int ans = sln.aggressiveCows(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean canWePlace(int[] stalls, int minD, int k){
        int last = stalls[0];
        int cowCnt=1;
        int n = stalls.length;
        
        for(int i=1;i<n;i++){
            if(stalls[i]-last>=minD){
                cowCnt++;
                last=stalls[i];
            }
            if(cowCnt==k) return true;
        }
        
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n=stalls.length;
        Arrays.sort(stalls);
        
        for(int minD=1;minD<=(stalls[n-1]-stalls[0]);minD++){
            if(canWePlace(stalls,minD,k)){
                continue;
            }
            else{
                return minD-1;
            }
        }
        
        return stalls[n-1]-stalls[0];
    }
}