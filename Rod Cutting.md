## 01. Rod Cutting

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/rod-cutting0840/1)

### Problem Description

**Task:** Given a rod of length n inches and an array price[], where price[i] denotes the value of a piece of length i (1-based Index). Determine the maximum value obtainable by cutting up the rod and selling the pieces.

> **Note:** The value of n is equal to the size of price array.

#### Examples

##### Example 1

- **Input:**
```text
price[] = [1, 5, 8, 9, 10, 17, 17, 20]Output: 22Explanation: The maximum obtainable value is 22 by cutting in two pieces of lengths 2 and 6, i.e., 5 + 17 = 22.
```

##### Example 2

- **Input:**
```text
price[] = [3, 5, 8, 9, 10, 17, 17, 20]Output: 24Explanation: The maximum obtainable value is 24 by cutting the rod into 8 pieces of length 1, i.e, 8*price[1] = 8*3 = 24.
```

##### Example 3

- **Input:**
```text
price[] = [3]Output: 3Explanation: There is only 1 way to pick a piece of length 1.
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n^2)
- **Expected Auxiliary Space Complexity:** O(n)

### Accepted Solutions (1)

#### Solution 1 (C++)

- **Submitted:** 2026-11-22 21:55:59
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
  int dp[1001][1001];
    int cutRod(vector<int> &price) {
        // code here
        int n=price.size();
        int len=n;
        memset(dp,-1,sizeof(dp));
        return solve(n,price,len);
    }
    int solve(int n, vector<int>& prices, int len){
        //base
        if(len==0){
            return 0;
        }
        if(n==0){
            return 0;
        }
        
        //provide
        if(dp[n][len]!=-1) return dp[n][len];
        
        int take=0,skip=0;
        if(n<=len){
            take = prices[n-1] + solve(n,prices,len-n);
        }
        skip = solve(n-1,prices,len);
        
        return dp[n][len] = max(take,skip);
    }
};
```

*Generated on: 11/22/2026, 9:56:00 PM*