//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String inputLine[] = read.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int sum = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.combinationSum(arr, sum);
            if (ans.size() == 0)
                System.out.println(-1);
            else {
                for (ArrayList<Integer> row : ans) {
                    Collections.sort(row);
                }
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() -
                        list2.size(); // If equal, smaller list comes first
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function template for JAVA

class Solution {
    // Function to find all combinations of elements
    // in array arr that sum to target.
    static void solve(int[] arr, ArrayList<Integer> temp, int idx, int n, int k, int sum, ArrayList<ArrayList<Integer>> ans){
        //base case
        if(idx==n){
            if(sum==k){
                ans.add(new ArrayList<>(temp));
                return;
            }
            else{
                return;
            }
        }

        //take
        if(sum+arr[idx]<=k){
            temp.add(arr[idx]); //push
            solve(arr,temp,idx,n,k,sum+arr[idx],ans);
            temp.remove(temp.size()-1); //pop
        }

        //skip
        solve(arr,temp,idx+1,n,k,sum,ans);

    }
    static ArrayList<ArrayList<Integer>> combinationSum(int[] arr, int target) {
        // add your code here
        int n = arr.length;
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        solve(arr,temp,0,n,target,0,ans);

        return ans;
    }
}