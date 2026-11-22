## Partitions with Given Difference

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1)

### Problem Description

**Task:** Given an array arr[] and an integer diff, count the number of ways to partition the array into two subsets such that the difference between their sums is equal to diff.

> **Note:** A partition in the array means dividing an array into two subsets say S_1 and S_2 such that the union of S_1 and S_2 is equal to the original array and each element is present in only one of the subsets.

#### Examples

##### Example 1

- **Input:**
```text
arr[] = [5, 2, 6, 4], diff = 3
```
- **Output:**
```text
1
```
- **Explanation:** There is only one possible partition of this array. Partition : [6, 4], [5, 2]. The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3.

##### Example 2

- **Input:**
```text
arr[] = [1, 1, 1, 1], diff = 0 Output: 6 Explanation: We can choose two 1's from indices [0,1], [0,2], [0,3], [1,2], [1,3], [2,3] and put them in sum1 and remaining two 1's in sum2.Thus there are total 6 ways for partition the array arr.
```

##### Example 3

- **Input:**
```text
arr[] = [3, 2, 5, 1], diff = 4 Output: 0Explanation: There is no possible partition of the array that satisfy the given difference.
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O( n*sum(arr))
- **Expected Auxiliary Space Complexity:** O( sum(arr))

### Accepted Solutions (4)

#### Solution 1 (C++)

- **Submitted:** 2026-11-22 23:16:52
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int dp[51][176];
    int countPartitions(vector<int>& arr, int diff) {
        // Code here
        int n=arr.size();
        int total=0;
        for(int i: arr){
            total+=i;
        }
        if((diff+total)%2==1) return 0;
        int target = (diff+total)/2;
        memset(dp,-1,sizeof(dp));
        return solve(n,arr,target);
    }
    int solve(int n, vector<int>& arr, int target){
        //base case
        if(target==0 and n==0) return 1;
        if(n==0) return 0;
        
        //provide
        if(dp[n][target]!=-1) return dp[n][target];
        
        int take=0,skip=0;
        if(arr[n-1]<=target){
            take = solve(n-1,arr,target-arr[n-1]);
        }
        skip = solve(n-1,arr,target);
        
        return dp[n][target] = take+skip;
    }
};
```

#### Solution 2 (C++)

- **Submitted:** 2024-05-24 22:04:22
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int mod=1e9+7;
    int solve(int i, int k, vector<int>& arr, vector<vector<int>>& dp){
        //base case
        if(i==0){
            if(k==0 && arr[0]==0) return 2;
            if(k==0) return 1;
            if(arr[0]==k) return 1;
            return 0;
        }
        
        if(dp[i][k]!=-1) return dp[i][k]%mod;
        
        int take=0;
        int skip=0;
        if(arr[i]<=k){
            take=solve(i-1,k-arr[i],arr,dp);
            skip=solve(i-1,k,arr,dp);
        }
        if(arr[i]>k){
            skip=solve(i-1,k,arr,dp);
        }
        
        return dp[i][k] = (take+skip)%mod;
    }
    int countPartitions(int n, int d, vector<int>& arr) {
        // Code here
        int sum=0;
        for(int it: arr) sum+=it;
        int k=(sum+d)/2;
        
        if(sum+d<0) return 0;
        if((sum+d)%2==1) return 0;
        
        vector<vector<int>> dp(n+1,vector<int>(k+1,-1));
        return solve(n-1,k,arr,dp);
    }
};
```

#### Solution 3 (C++)

- **Submitted:** 2024-05-24 22:01:34
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int mod=1e9+7;
    int solve(int i, int k, vector<int>& arr, vector<vector<int>>& dp){
        //base case
        if(i==0){
            if(k==0 && arr[0]==0) return 2;
            if(k==0) return 1;
            if(arr[0]==k) return 1;
            return 0;
        }
        
        if(dp[i][k]!=-1) return dp[i][k]%mod;
        
        int take=0;
        int skip=0;
        if(arr[i]<=k){
            take=solve(i-1,k-arr[i],arr,dp);
            skip=solve(i-1,k,arr,dp);
        }
        if(arr[i]>k){
            skip=solve(i-1,k,arr,dp);
        }
        
        return dp[i][k] = (take+skip)%mod;
    }
    int countPartitions(int n, int d, vector<int>& arr) {
        // Code here
        int sum=0;
        for(int it: arr) sum+=it;
        int k=(sum-d)/2;
        
        if(sum-d<0) return 0;
        if((sum-d)%2==1) return 0;
        
        vector<vector<int>> dp(n+1,vector<int>(k+1,-1));
        return solve(n-1,k,arr,dp);
    }
};
```

#### Solution 4 (C++)

- **Submitted:** 2024-05-24 21:51:58
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    int mod=1e9+7;
    int solve(int i, int k, vector<int>& arr, vector<vector<int>>& dp){
        //base case
        if(i==0){
            if(k==0 && arr[0]==0) return 2;
            if(k==0 || k==arr[0]) return 1;
            return 0;
        }
        
        if(dp[i][k]!=-1) return dp[i][k]%mod;
        
        int take=0;
        int skip=0;
        if(arr[i]<=k){
            take=solve(i-1,k-arr[i],arr,dp);
            skip=solve(i-1,k,arr,dp);
        }
        if(arr[i]>k){
            skip=solve(i-1,k,arr,dp);
        }
        
        return dp[i][k] = (take+skip)%mod;
    }
    int countPartitions(int n, int d, vector<int>& arr) {
        // Code here
        int sum=0;
        for(int it: arr) sum+=it;
        int k=(sum-d)/2;
        
        if(sum-d<0) return 0;
        if((sum-d)%2==1) return 0;
        
        vector<vector<int>> dp(n+1,vector<int>(k+1,-1));
        return solve(n-1,k,arr,dp);
    }
};
```

*Generated on: 11/22/2026, 11:17:16 PM*
