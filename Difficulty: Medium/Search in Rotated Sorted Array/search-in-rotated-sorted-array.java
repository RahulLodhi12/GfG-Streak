//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] nums, int x) {
        // Complete this function
        int n=nums.length;
        int s=0,e=n-1;

        while (s<=e){
            int m = s + (e-s)/2;

            //check if x at 'm', must be 1st statement
            if(nums[m]==x){
                return m;
            }

            if(nums[s]<=nums[m]){ //left is sorted
                if(x>=nums[s] && x<=nums[m]){ //x present b/w 's' and 'm'
                    e=m-1;
                }
                else{
                    s=m+1;
                }
            }
            else{ //right is sorted
                if(x>=nums[m] && x<=nums[e]){ //x present b/w 's' and 'm'
                    s=m+1;
                }
                else{
                    e=m-1;
                }
            }
        }

        return -1;
    }
}