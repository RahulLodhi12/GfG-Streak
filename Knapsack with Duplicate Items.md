## 01. Knapsack with Duplicate Items

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1)

### Problem Description

**Task:** Given a set of item whose weights and values are represented by wt[] and val[] respectively. Also given a knapsack with a weight limit capacity. The task is to fill the knapsack in such a way that we get the maximum profit. Note: Each item can be taken any number of times.Examples:Input: val[] = [1, 1], wt[] = [2, 1], capacity = 3

#### Examples

##### Example 1

- **Output:**
```text
3
```
- **Explanation:** The optimal choice is to pick the 2nd element 3 times.

##### Example 2

- **Input:**
```text
val[] = [10, 40, 50, 70], wt[] = [1, 3, 4, 5], capacity = 8
```
- **Output:**
```text
0
```
- **Explanation:** We can't pick any element. Hence, total profit is 0.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n * capacity)
- **Expected Auxiliary Space Complexity:** O(capacity)

### Accepted Solutions (1)

#### Solution 1 (C++)

- **Submitted:** 2026-11-19 22:10:09
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    int dp[1001][1001];
    int knapSack(vector<int>& val, vector<int>& wt, int capacity) {
        // code here
        int n=wt.size();
        memset(dp,-1,sizeof(dp));
        return solve(n,val,wt,capacity);
    }
    int solve(int n, vector<int>& val, vector<int>& wt, int capacity){
        //base case
        if(capacity==0){
            return 0;
        }
        if(n==0){
            return 0;
        }
        
        //provide
        if(dp[n][capacity]!=-1) return dp[n][capacity];
        
        int take=0,skip=0;
        if(wt[n-1]<=capacity){
            take = val[n-1] + solve(n,val,wt,capacity-wt[n-1]);
        }
        skip = solve(n-1,val,wt,capacity);
        
        return dp[n][capacity] = max(take,skip);
    }
};
```

*Generated on: 11/19/2026, 10:10:15 PM*