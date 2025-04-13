//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Number of test cases
        for (int g = 0; g < t; g++) {
            // Read input array as a string, split by space, and convert to integers
            String[] str = br.readLine().trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            // Print the result from maxLen function
            System.out.println(new Solution().maxLen(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    int maxLen(int nums[]) {
        // code here
        int n=nums.length;
        int maxLen=0;

        HashMap<Integer,Integer> mpp = new HashMap<>(); //map<prefixSum,idx>
        int prefixSum=0;

        mpp.put(0,-1);

        for(int i=0;i<n;i++){
            prefixSum+=nums[i];

            if(mpp.containsKey(prefixSum-0)){
                maxLen = Math.max(maxLen,i-mpp.get(prefixSum-0));
                continue;
            }

            mpp.put(prefixSum,i);
        }

        return maxLen;
    }
}