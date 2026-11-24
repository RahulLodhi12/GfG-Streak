## 01. Maximize The Cut Segments

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/cutted-segments1642/1)

### Problem Description

**Task:** Given an integer n denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either x , y or z. Here x, y, and z are integers.After performing all the cut operations, your total number of cut segments must be maximum. Return the maximum number of cut segments possible.Note: if no segment can be cut then return 0.Examples:Input: n = 4, x = 2, y = 1, z = 1

#### Examples

##### Example 1

- **Output:**
```text
4
```
- **Explanation:** Total length is 4, and the cut lengths are 2, 1 and 1. We can make maximum 4 segments each of length 1.

##### Example 2

- **Input:**
```text
n = 5, x = 5, y = 3, z = 2
```
- **Output:**
```text
0
```
- **Explanation:** Here the total length is 7, and the cut lengths are 8, 9, and 10. We cannot cut the segment into lengths that fully utilize the segment, so the output is 0.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (2)

#### Solution 1 (C++)

- **Submitted:** 2026-11-24 17:05:08
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int dp[4][10001];
    int maximizeCuts(int n, int x, int y, int z) {
        // code here
        vector<int> nums;
        nums.push_back(x);
        nums.push_back(y);
        nums.push_back(z);
        int m=nums.size();
        memset(dp,-1,sizeof(dp));
        int res = solve(m,nums,n);
        return res<0 ? 0 : res;
    }
    int solve(int n, vector<int>& nums, int target){
        //base case
        if(n==0){
            if(target==0) return 0;
            return -1e9;
        }
        
        //provide
        if(dp[n][target]!=-1) return dp[n][target];
        
        int take=-1e9,skip=-1e9;
        if(nums[n-1]<=target){
            take = 1 + solve(n,nums,target-nums[n-1]);
        }
        skip = solve(n-1,nums,target);
        
        return dp[n][target] = max(take,skip);
    }
};
```

#### Solution 2 (C++)

- **Submitted:** 2024-08-16 10:54:34
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution
{
    public:
    //Function to find the maximum number of cuts.
    int dp[10001];
    int solve(int x, int y, int z, int n){
        //base case
        if(n<0){
            return INT_MIN;
        }
        if(n==0){
            return 0;
        }
        
        if(dp[n]!=-1) return dp[n];
        
        int op1 = 1+solve(x,y,z,n-x);
        int op2 = 1+solve(x,y,z,n-y);
        int op3 = 1+solve(x,y,z,n-z);
        
        return dp[n] = max({op1,op2,op3});
    }
    int maximizeTheCuts(int n, int x, int y, int z)
    {
        //Your code here
        memset(dp,-1,sizeof(dp));
        int ans = solve(x,y,z,n);
        // cout<<ans<<" "<<INT_MIN<<" ";
        if(ans<=0) return 0;
        
        return ans;
    }
};
```

*Generated on: 11/24/2026, 5:05:23 PM*