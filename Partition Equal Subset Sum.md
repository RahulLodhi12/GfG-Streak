## 01. Partition Equal Subset Sum

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/subset-sum-problem2014/1)

### Problem Description

**Task:** Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.Note: Each element must be in exactly one subset.Examples:Input: arr = [1, 5, 11, 5]

#### Examples

##### Example 1

- **Output:**
```text
true
```
- **Explanation:** The two parts are [1, 5, 5] and [11].

##### Example 2

- **Input:**
```text
arr = [1, 3, 5]
```
- **Output:**
```text
false
```
- **Explanation:** This array can never be partitioned into two such parts.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(sum(arr) * n)
- **Expected Auxiliary Space Complexity:** O(sum(arr))

### Accepted Solutions (1)

#### Solution 1 (C++)

- **Submitted:** 2026-11-16 00:10:53
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    int dp[101][20001];
    bool equalPartition(vector<int>& arr) {
        // code here
        int n=arr.size();
        int sum=0;
        for(int i: arr){
            sum+=i;
        }
        
        if(sum%2==1) return false; //odd
        int k=sum/2;
        memset(dp,-1,sizeof(dp));
        return solve(n,arr,k);
    }
    bool solve(int n, vector<int>& arr, int k){
        //base case
        if(k==0){
            return true;
        }
        if(n==0){
            return false;
        }
        
        //provide
        if(dp[n][k]!=-1) return dp[n][k];
        
        return dp[n][k] = solve(n-1,arr,k-arr[n-1]) || solve(n-1,arr,k);
    }
};
```

*Generated on: 11/16/2026, 12:11:05 AM*