## 01. Subset Sum Problem

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1)

### Problem Description

**Task:** Given an array of positive integers arr[] and a value sum, find if there is a subset of arr[] with sum equal to given sum. Examples:Input: arr[] = [3, 34, 4, 12, 5, 2], sum = 9Output: true

#### Examples

##### Example 1

- **Explanation:** Here there exists a subset with target sum = 9, 4+3+2 = 9.

##### Example 2

- **Input:**
```text
arr[] = [3, 34, 4, 12, 5, 2], sum = 30
```
- **Output:**
```text
trueExplanation: The entire array can be taken as a subset, giving 1 + 2 + 3 = 6.
```
- **Explanation:** There is no subset with target sum 30.Input: arr[] = [1, 2, 3], sum = 6

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(sum*n)
- **Expected Auxiliary Space Complexity:** O(sum)

### Accepted Solutions (4)

#### Solution 1 (C++)

- **Submitted:** 2026-11-16 22:25:38
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    bool isSubsetSum(vector<int>& arr, int sum) {
        // code here
        int n=arr.size();
        bool dp[n+1][sum+1];
        //1. Initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }
        //2. Iterative
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
};
```

#### Solution 2 (C++)

- **Submitted:** 2026-11-16 22:08:38
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    bool isSubsetSum(vector<int>& arr, int sum) {
        // code here
        int n=arr.size();
        bool dp[n+1][sum+1];
        //1. Initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0){
                    dp[i][j]=false;
                }
                if(j==0){
                    dp[i][j]=true;
                }
            }
        }
        //2. Iterative
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
};
```

#### Solution 3 (C++)

- **Submitted:** 2026-11-12 21:00:30
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int dp[201][10001];
    bool isSubsetSum(vector<int>& arr, int sum) {
        // code here
        int n=arr.size();
        memset(dp,-1,sizeof(dp));
        return solve(n,arr,sum);
    }
    
    bool solve(int n, vector<int>& arr, int sum){
        //base case
        if(n==0 and sum!=0) return false;
        if(sum==0) return true;
        
        //provide
        if(dp[n][sum]!=-1) return dp[n][sum];
        
        //take + skip -> dono mein se konsa part 'true' dega,
        //that's why 'OR' is used among [take || skip]
        return dp[n][sum] = solve(n-1,arr,sum-arr[n-1]) || solve(n-1,arr,sum);
    }
};
```

#### Solution 4 (C++)

- **Submitted:** 2026-11-12 20:58:19
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    int dp[201][10001];
    bool isSubsetSum(vector<int>& arr, int sum) {
        // code here
        int n=arr.size();
        memset(dp,-1,sizeof(dp));
        return solve(n,arr,sum);
    }
    
    bool solve(int n, vector<int>& arr, int sum){
        //base case
        if(n==0 and sum!=0) return false;
        if(sum==0) return true;
        
        //provide
        if(dp[n][sum]!=-1) return dp[n][sum];
        
        //take
        return dp[n][sum] = solve(n-1,arr,sum-arr[n-1]) || solve(n-1,arr,sum);
        //skip
    }
};
```

*Generated on: 11/16/2026, 10:25:46 PM*