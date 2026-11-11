## 01. 0 - 1 Knapsack Problem

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)

### Problem Description

**Task:** Given two arrays, val[] and wt[], where each element represents the value and weight of an item respectively, and an integer W representing the maximum capacity of the knapsack (the total weight it can hold).Put the items into the knapsack such that the total value obtained is maximum without exceeding the capacity W.Note: You can either include an item completely or exclude it entirely — fractional selection of items is not allowed. Each item is available only once.Examples :Input: W = 4, val[] = [1, 2, 3], wt[] = [4, 5, 1]Output: 3Explanation: Choose the last item, which weighs 1 unit and has a value of 3.Input: W = 3, val[] = [1, 2, 3], wt[] = [4, 5, 6] Output: 0Explanation: Every item has a weight exceeding the knapsack's capacity (3).Input: W = 5, val[] = [10, 40, 30, 50], wt[] = [5, 4, 2, 3] Output: 80Explanation: Choose the third item (value 30, weight 2) and the last item (value 50, weight 3) for a total value of 80.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O (n * W)
- **Expected Auxiliary Space Complexity:** O (W)

### Accepted Solutions (2)

#### Solution 1 (C++)

- **Submitted:** 2026-11-11 23:04:09
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int dp[1001][1001];
    int knapsack(int W, vector<int> &val, vector<int> &wt) {
        // code here
        int n=wt.size();
        memset(dp, -1, sizeof(dp));
        return solve(n,W,val,wt);
    }
    
    int solve(int n, int W, vector<int> &val, vector<int> &wt){
        //base case
        if(n==0 || W==0) return 0;
        
        //re-use
        if(dp[n][W]!=-1) return dp[n][W];
        
        //take
        int take=0,skip=0;
        if(wt[n-1]<=W){
            take = val[n-1] + solve(n-1,W-wt[n-1],val,wt);
            skip = 0 + solve(n-1,W,val,wt);
        }
        if(wt[n-1]>W){
            skip = 0 + solve(n-1,W,val,wt);
        }
           
        return dp[n][W] = max(take,skip);
    }
};
```

#### Solution 2 (C++)

- **Submitted:** 2024-08-24 21:52:03
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    // Function to return max value that can be put in knapsack of capacity W.
     vector<vector<int>> memo;

    int knapsackhelper(int index, int W, vector<int>& wt, vector<int>& val) {
        if (index == 0 ) {
            return 0;
        }

        if (memo[index][W] != -1) {
            return memo[index][W];
        }

        int ans = 0;
        if (wt[index - 1] <= W) {
            ans += val[index - 1] + knapsackhelper(index - 1, W - wt[index - 1], wt, val);
            } 
            ans = max(ans,knapsackhelper(index - 1, W, wt, val));
    

        memo[index][W] = ans;
        return ans;
    }

    int knapSack(int W, vector<int>& wt, vector<int>& val) {
        int n = val.size();
        memo.resize(n + 1, vector<int>(W + 1, -1));
        return knapsackhelper(n, W, wt, val);
    }
};
```

*Generated on: 11/11/2026, 11:05:54 PM*