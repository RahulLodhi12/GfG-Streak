## 01. Minimum Cost to Fill Given Weight

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1)

### Problem Description

**Task:** Given a bag of size w kg and you are provided costs of packets different weights of oranges in array cost[], find the minimum total cost to buy exactly w kg oranges
The cost of 1 kg orange is present at index 0 and in general arr[i] has cost of (i+1) kg orange.
cost[i] = -1 means that 'i+1' kg packet of orange is unavailable.
If it is not possible to buy exactly w kg oranges then return -1. It may be assumed that there is an infinite supply of all available packet types.

#### Examples

##### Example 1

- **Input:**
```text
cost[] = [20, 10, 4, 50, 100], w = 5
```
- **Output:**
```text
14
```
- **Explanation:** The minimum cost is 14 by purchasing a 2kg packet for 10 and a 3kg packet for 4.

##### Example 2

- **Input:**
```text
cost[] = [-1, -1, 4, 3, -1], w = 5
```
- **Output:**
```text
-1
```
- **Explanation:** It is not possible to buy 5 kgs.

#### Constraints

- **1.** `1 ≤ cost.size(), w ≤ 2*10³¹ ≤ cost[i] ≤ 10⁵`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n*w)
- **Expected Auxiliary Space Complexity:** O(n*w)

### Accepted Solutions (2)

#### Solution 1 (C++)

- **Submitted:** 2026-11-24 00:01:07
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int dp[2001][2001];
    int minimumCost(vector<int> &cost, int w) {
        // code here
        int n=cost.size();
        memset(dp,-1,sizeof(dp));
        int res = solve(n,cost,w);
        return res==100001 ? -1 : res;
    }
    int solve(int n, vector<int>& cost, int w){
        //base case
        if(w==0 and n==0) return 0;
        if(n==0) return 100001;
    
        //provide
        if(dp[n][w]!=-1) return dp[n][w];
    
        int take=100001,skip=100001;
        if(n<=w and cost[n-1]!=-1){
            take = cost[n-1] + solve(n,cost,w-n);
        }
        skip = solve(n-1,cost,w);
        
        return dp[n][w] = min(take,skip);
    }
};
```

#### Solution 2 (C++)

- **Submitted:** 2024-05-28 23:51:14
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    int solve(vector<int>cost, vector<vector<int>>&dp, int n, int w, int i){
        if(w==0) return 0;
        if (i >= n || w<0) return 1e9;
        
        if(dp[i][w]!=-1) return dp[i][w];
        
       
       int notTake=solve(cost,dp,n,w,i+1);
        int take=INT_MAX;
        if(cost[i]!=-1 && w>=i+1){
            take=cost[i]+solve(cost,dp,n,w-(i+1),i);
        }
        
        return dp[i][w]= min(take, notTake);
    }
    int minimumCost(int n, int w, vector<int> &cost) {
        vector<vector<int>>dp(n+1 , vector<int>(w+1 , -1));
        int result = solve(cost, dp, n, w, 0);
        return (result >= INT_MAX) ? -1 : result;
    }
};
```

*Generated on: 11/24/2026, 12:01:51 AM*