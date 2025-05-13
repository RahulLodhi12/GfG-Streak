//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            String[] str =
                (br.readLine()).trim().split(" "); // Reading input as a string array
            int arr[] = new int[str.length]; // Creating integer array from the input
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            // Getting the result from the Solution class
            ArrayList<Integer> result = new Solution().subsetSums(arr);
            Collections.sort(result);
            // Printing the result in space-separated format
            for (int i = 0; i < result.size(); i++) {
                if (i != 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();    // Print new line after each test case
            System.out.println("~"); // Print new line after each test case
        }
    }
}

// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    public void solve(int[] arr, int idx, int n, int sum, ArrayList<Integer> ans){
        //base case
        if(idx==n){
            ans.add(sum);
            return;
        }
        
        //take
        solve(arr,idx+1,n,sum+arr[idx],ans);
        
        //skip
        solve(arr,idx+1,n,sum,ans);
    }
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        solve(arr,0,n,0,ans);
        
        return ans;
    }
}