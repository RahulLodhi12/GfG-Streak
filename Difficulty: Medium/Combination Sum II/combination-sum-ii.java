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
            ArrayList<ArrayList<Integer>> ans = ob.uniqueCombinations(arr, sum);
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
    static void combinationSum2_optimal(int[] arr, ArrayList<Integer> temp, int i, int n, int target, int sum, ArrayList<ArrayList<Integer>> ans){
        //base case
        if(sum==target){
            ans.add(new ArrayList<>(temp)); //O(k), because we are putting a ds into another ds
            return;
        }

        for(int k=i;k<n;k++){
            if(k>i && arr[k]==arr[k-1]) continue;
            if(sum+arr[k]>target) break;

            temp.add(arr[k]);
            combinationSum2_optimal(arr,temp,k+1,n,target,sum+arr[k],ans);
            temp.remove(temp.size()-1);
        }
    }
    
    static ArrayList<ArrayList<Integer>> uniqueCombinations(int[] arr, int k) {
        // add your code here
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = arr.length;

        Arrays.sort(arr);
        
        combinationSum2_optimal(arr,temp,0,n,k,0,ans);

        return new ArrayList<>(ans);
    }
}