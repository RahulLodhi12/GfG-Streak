//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends

class Solution {
    public static boolean Search(int[] nums, int x) {
        // code here
        int n=nums.length;
        int s=0,e=n-1;

        while (s<=e){
            int m = s + (e-s)/2;

            //check if x at 'm', must be 1st statement
            if(nums[m]==x){
                return true;
            }

            //check if 's','m','e' points to same elements
            if(nums[s]==nums[m] && nums[m]==nums[e]){
                s++;
                e--;
                continue; //continue because after s++ and e--, we will get new 'mid' pointer,
                // so we can't proceed with later code.
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

        return false;
    }
}



//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
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
            Solution obj = new Solution();
            boolean res = obj.Search(arr, k);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            // System.out.println(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends