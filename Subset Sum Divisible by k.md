## 01. Subset Sum Divisible by k

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/subset-with-sum-divisible-by-m2546/1)

### Problem Description

**Task:** Given an array arr[] of positive integers and a value k, check if sum of any non-empty subset of the given array is divisible by k.

#### Examples

##### Example 1

- **Input:**
```text
arr[] = [3, 1, 7, 5] , k = 6
```
- **Output:**
```text
true
```
- **Explanation:** If we take the subset {7, 5} then sum will be 12 which is divisible by 6.

##### Example 2

- **Input:**
```text
arr[] = [1, 2, 6] , k = 5
```
- **Output:**
```text
false
```
- **Explanation:** All possible subsets of the given set are {1}, {2}, {6}, {1, 2}, {2, 6}, {1, 6} and {1, 2, 6}. There is no subset whose sum is divisible by 5.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n*k)
- **Expected Auxiliary Space Complexity:** O(k)

### Accepted Solutions (1)

#### Solution 1 (C++)

- **Submitted:** 2026-11-17 20:29:21
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    int dp[1001][1001];
    bool divisibleByK(vector<int>& arr, int k) {
        // code here
        int n=arr.size();
        memset(dp,-1,sizeof(dp));
        return solve(n,arr,0,k);
    }
    bool solve(int n, vector<int>& arr, int sum, int k){
        //base case
        if(sum>0 and sum%k==0){
            return true;
        }
        if(n==0){
            return false;
        }
        
        //provide
        if(dp[n][sum]!=-1) return dp[n][sum];
        
        return dp[n][sum] = solve(n-1,arr,sum+arr[n-1],k) || solve(n-1,arr,sum,k);
    }
};
```

*Generated on: 11/17/2026, 8:29:35 PM*