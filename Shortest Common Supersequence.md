## 01. Shortest Common Supersequence

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1)

### Problem Description

**Task:** Given two strings s1 and s2, find the length of the smallest string which has both s1 and s2 as its sub-sequences.Note: s1 and s2 can have both uppercase and lowercase English letters.

#### Examples

##### Example 1

- **Input:**
```text
s1 = "geek", s2 = "eke"
```
- **Output:**
```text
5
```
- **Explanation:** String "geeke" has both string "geek" and "eke" as subsequences.

##### Example 2

- **Input:**
```text
s1 = "AGGTAB", s2 = "GXTXAYB"
```
- **Output:**
```text
9
```
- **Explanation:** String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.

##### Example 3

- **Input:**
```text
s1 = "geek", s2 = "ek"
```
- **Output:**
```text
4
```
- **Explanation:** String "geek" has both string "geek" and "ek" as subsequences.

#### Constraints

- **1.** `1 ≤ s1.size(), s2.size() ≤ 500`

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n * m)
- **Expected Auxiliary Space Complexity:** O(m)

### Accepted Solutions (3)

#### Solution 1 (C++)

- **Submitted:** 2026-11-27 23:40:21
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int dp[501][501];
    int minSuperSeq(string &s1, string &s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        
        memset(dp,-1,sizeof(dp));
        int LCS = solve(s1,s2,n,m);
        
        return (n+m) - LCS;
    }
    int solve(string &s1, string &s2, int n, int m){
        //base case
        if(n==0 || m==0) return 0;
        
        //provide
        if(dp[n][m]!=-1) return dp[n][m];
        
        if(s1[n-1]==s2[m-1]){
            return dp[n][m] = 1 + solve(s1,s2,n-1,m-1);
        }
        
        int op1 = solve(s1,s2,n-1,m);
        int op2 = solve(s1,s2,n,m-1);
        
        return dp[n][m] = max(op1,op2);
    }
    
};
```

#### Solution 2 (C++)

- **Submitted:** 2023-11-17 15:57:53
- **Status:** Correct
- **Marks:** 0

```cpp
//User function template for C++


class Solution
{
    public:
    //Function to find length of shortest common supersequence of two strings.
    int dp[101][101];
    int solve(int m, int n, string x, string y){
        //base cases
        if(m==0 || n==0) return 0;
        
        //provide
        if(dp[m][n] != -1) return dp[m][n];
        
        if(x[m-1]==y[n-1]) return 1 + solve(m-1,n-1,x,y);
        
        int op1 = solve(m,n-1,x,y);
        int op2 = solve(m-1,n,x,y);
        
        return dp[m][n] = max(op1,op2);
    }
    
    int longestcommonSubseq(string x, string y, int m, int n){
        memset(dp,-1,sizeof(dp));
        
        int ans = solve(m,n,x,y);
        return ans;
    }
    
    int shortestCommonSupersequence(string X, string Y, int m, int n)
    {
        //code here
        int lcs = longestcommonSubseq(X,Y,m,n);
        
        return m + n - lcs;
    }
};
```

#### Solution 3 (C++)

- **Submitted:** 2023-11-15 00:18:08
- **Status:** Correct
- **Marks:** 4

```cpp
//User function template for C++


class Solution
{
    public:
    //Function to find length of shortest common supersequence of two strings.
    int dp[101][101];
    int solve(int i, int j, string x, string y, int m, int n){
        //base cases
        if(i==m || j==n) return 0;
        if(x[i]==y[j]) return 1 + solve(i+1,j+1,x,y,m,n);
        
        //provide
        if(dp[i][j] != -1) return dp[i][j];
        
        int op1 = solve(i,j+1,x,y,m,n);
        int op2 = solve(i+1,j,x,y,m,n);
        
        return dp[i][j] = max(op1,op2);
    }
    
    int longestcommonSubseq(string x, string y, int m, int n){
        memset(dp,-1,sizeof(dp));
        
        int ans = solve(0,0,x,y,m,n);
        return ans;
    }
    
    int shortestCommonSupersequence(string X, string Y, int m, int n)
    {
        //code here
        int lcs = longestcommonSubseq(X,Y,m,n);
        
        return m + n - lcs;
    }
};
```

*Generated on: 11/27/2026, 11:40:42 PM*