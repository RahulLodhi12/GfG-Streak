//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        // Loop for each test case
        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution(); // Create an object of Solution class
            System.out.println(
                ob.perfectSum(nums, target)); // Call perfectSum and print the result
            System.out.println("~");          // Call perfectSum and print the result
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to calculate the number of subsets with a given sum
    public static int subSeq_sum_K(int[] arr, int idx, int n, int k, int sum, int[][] dp){
        //base case
        if(idx==n){
            if(sum==k) return 1;
            else return 0;
        }

        //check
        if(dp[idx][sum]!=-1) return dp[idx][sum];

        //take
        int take=0;
        sum+=arr[idx];
        take = subSeq_sum_K(arr,idx+1,n,k,sum,dp);

        //skip
        int skip=0;
        sum-=arr[idx];
        skip = subSeq_sum_K(arr,idx+1,n,k,sum,dp);

        return dp[idx][sum] = take+skip;
    }
    public int perfectSum(int[] nums, int target) {
        // code here
        int n=nums.length;
        int total=0;
        for(int i: nums){
            total+=i;
        }
        
        int[][] dp = new int[n+1][total+1];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return subSeq_sum_K(nums,0,n,target,0,dp);
    }
}