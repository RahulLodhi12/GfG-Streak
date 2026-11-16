## 01. Partition Into 2 Subsets with Min Sum Diff

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1)

### Problem Description

**Task:** Given an array arr[] containing non-negative integers, divide it into two sets set1 and set2 such that the absolute difference between their sums is minimum and find the minimum difference.

#### Examples

##### Example 1

- **Input:**
```text
arr[] = [1, 6, 11, 5]
```
- **Output:**
```text
1 Subset1 = [1, 5, 6], sum of Subset1 = 12 Subset2 = [11], sum of Subset2 = 11 Hence, minimum difference is 1.
```

##### Example 2

- **Input:**
```text
arr[] = [1, 4]
```
- **Output:**
```text
3 Subset1 = [1], sum of Subset1 = 1 Subset2 = [4], sum of Subset2 = 4Hence, minimum difference is 3.
```

##### Example 3

- **Input:**
```text
arr[] = [1]
```
- **Output:**
```text
1 Subset1 = [1], sum of Subset1 = 1 Subset2 = [], sum of Subset2 = 0Hence, minimum difference is 1.
```

#### Constraints

- **1.** `1 ≤ arr.size()*|sum of array elements| ≤ 10⁵¹ ≤ arr[i] ≤ 10⁵`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n*|sum of array elements|)
- **Expected Auxiliary Space Complexity:** O(n*|sum of array elements|)

### Accepted Solutions (2)

#### Solution 1 (C++)

- **Submitted:** 2026-11-16 23:46:38
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    //THIS Solution only works for Positive input arrays, not works with Negative input array(e.g. Leetcode)
    vector<vector<int>> dp;
    int minDifference(vector<int>& arr) {
        // code here
        int n=arr.size();
        int total=0;
        for(int i: arr){
            total+=i;
        }
        dp.assign(n + 1, vector<int>(total + 1, -1));
        return solve(n,arr,0,total);
    }
    int solve(int n, vector<int>& nums, int sum, int total){
            //base case
            if(n==0){
                return abs(total-(2*sum)); //s2 = total - 2*s1
            }

            //provide
            if(dp[n][sum]!=-1) return dp[n][sum];

            int take = solve(n-1,nums,sum+nums[n-1],total); //sum - s1
            int skip = solve(n-1,nums,sum,total);

            return dp[n][sum] = min(take,skip); //minimum difference
        }
    
};
```

#### Solution 2 (C++)

- **Submitted:** 2026-11-16 23:44:40
- **Status:** Correct
- **Marks:** 8

```cpp
class Solution {
  public:
    vector<vector<int>> dp;
    int minDifference(vector<int>& arr) {
        // code here
        int n=arr.size();
        int total=0;
        for(int i: arr){
            total+=i;
        }
        // dp.assign(n+1,vector<int>(total+1, -1);
        dp.assign(n + 1, vector<int>(total + 1, -1));
        return solve(n,arr,0,total);
    }
    int solve(int n, vector<int>& nums, int sum, int total){
            //base case
            // if(cnt>nums.size()/2) return INT_MAX;
            if(n==0){
                // cout<<cnt<<" ";
                return abs(total-(2*sum)); //s2 = total - 2*s1
                // return INT_MAX;
            }

            //provide
            if(dp[n][sum]!=-1) return dp[n][sum];

            int take = solve(n-1,nums,sum+nums[n-1],total); //sum - s1
            int skip = solve(n-1,nums,sum,total);

            return dp[n][sum] = min(take,skip); //minimum difference
        }
    
};
```

*Generated on: 11/16/2026, 11:46:50 PM*