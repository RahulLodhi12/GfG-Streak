//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution ob = new Solution();
            int ans = ob.subsetXORSum(nums); // Call the function and store result
            System.out.println(ans);         // Output the result
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    int solve(int arr[], int idx, int n, int xor, int[][] dp){
        //base case
        if(idx==n){
            return xor;
        }
        
        //check
        if(dp[idx][xor]!=-1) return dp[idx][xor];
        
        //take
        int take = solve(arr,idx+1,n,xor^arr[idx],dp);
        
        //skip
        int skip = solve(arr,idx+1,n,xor,dp);
        
        return dp[idx][xor] = take+skip; //sum -> take ka xor's + skip ka xor's
    }
    int subsetXORSum(int arr[]) {
        // code here
        int n=arr.length;
        int sum=0;
        
        for(int i: arr){
            sum+=i;
        }
        
        int[][] dp = new int[n+1][sum];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return solve(arr,0,n,0,dp);
    }
}