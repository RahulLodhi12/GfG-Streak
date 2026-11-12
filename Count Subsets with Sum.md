## 01. Count Subsets with Sum

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1)

### Problem Description

**Task:** Given an array arr[] of non-negative integers and an integer target, count all subsets of the array whose sum is equal to the given target.Examples:Input: arr[] = [5, 2, 3, 10, 6, 8], target = 10

#### Examples

##### Example 1

- **Output:**
```text
3
```
- **Explanation:** The empty subset is the only subset with a sum of 0.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n*target)
- **Expected Auxiliary Space Complexity:** O(n*target)

### Accepted Solutions (2)

#### Solution 1 (C++)

- **Submitted:** 2026-11-13 00:06:54
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int dp[1001][1001];
    int perfectSum(vector<int>& arr, int target) {
        // code here
        int n=arr.size();
        memset(dp,-1,sizeof(dp));
        return solve(n,arr,target);
    }
    
    int solve(int n, vector<int>& arr, int target){
        //base case
        if(target==0 and n==0) return 1;   
        if(n==0) return 0;
        
        //provide
        if(dp[n][target]!=-1) return dp[n][target];
        
        //take + skip
        if(arr[n-1]<=target)
            return dp[n][target] = solve(n-1,arr,target-arr[n-1]) + solve(n-1,arr,target);
        
        //skip
        return dp[n][target] = solve(n-1,arr,target);
    }
};
```

#### Solution 2 (C++)

- **Submitted:** 2025-05-13 09:32:18
- **Status:** Correct
- **Marks:** 4

```cpp
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
```

*Generated on: 11/13/2026, 12:07:33 AM*