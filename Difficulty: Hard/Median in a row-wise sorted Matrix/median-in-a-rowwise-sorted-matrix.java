//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int R = Integer.parseInt(read.readLine());
            int C = Integer.parseInt(read.readLine());
            int matrix[][] = new int[R][C];
            int c = 0;
            for (int i = 0; i < R; i++) {
                String line[] = read.readLine().trim().split(" ");
                for (int j = 0; j < C; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int upperBound(int[] nums, int x){
        int n=nums.length;
        int s=0,e=n-1;

        int idx=n; //ans;

        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m]<=x){
                s=m+1;
            }
            else if(nums[m]>x){ //ans will be here
                idx = Math.min(idx,m);
                e=m-1;
            }
        }

        return idx;
    }
    int cntSmallEqual(int mat[][], int mid, int n, int m){
        int cnt=0;
        for(int i=0;i<n;i++){
            cnt += upperBound(mat[i],mid);
        }
        return cnt;
    }
    int median(int mat[][]) {
        // code here
        int s=Integer.MAX_VALUE;
        int e=Integer.MIN_VALUE;
        
        int n=mat.length;
        int m=mat[0].length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                s=Math.min(s,mat[i][j]);
                e=Math.max(e,mat[i][j]);
            }
        }
        
        int req = (n*m)/2;
        
        while(s<=e){
            int mid = s + (e-s)/2; //median
            
            int smallEqual = cntSmallEqual(mat,mid,n,m);
            
            if(req<smallEqual){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        
        return s;
    }
}