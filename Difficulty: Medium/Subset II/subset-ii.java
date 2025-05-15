//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter ot = new PrintWriter(System.out);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.printUniqueSubsets(nums);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            ot.print("[ ");
            for (int i = 0; i < ans.size(); i++) {
                ot.print("[ ");
                for (int j = 0; j < ans.get(i).size(); j++)
                    ot.print(ans.get(i).get(j) + " ");
                ot.print("]");
            }
            ot.println(" ]");
        }
        ot.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static void solve(int[] arr, ArrayList<Integer> temp, int idx, int n, Set<ArrayList<Integer>> ans){
        //base case
        if(idx==n){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //take
        temp.add(arr[idx]);
        solve(arr,temp,idx+1,n,ans);

        //skip
        temp.remove(temp.size()-1);
        solve(arr,temp,idx+1,n,ans);
    }
    public static ArrayList<ArrayList<Integer>> printUniqueSubsets(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> temp = new ArrayList<>();
        Set<ArrayList<Integer>> ans = new HashSet<>();

        solve(nums,temp,0,n,ans);
        
        return new ArrayList<>(ans);
    }
}