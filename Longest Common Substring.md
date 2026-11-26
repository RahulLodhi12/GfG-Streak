## 01. Longest Common Substring

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1)

### Problem Description

**Task:** Given two strings s1 and s2, determine the length of the longest substring that appears in both strings.Examples:Input: s1 = "ABCDGH", s2 = "ACDGHR"

#### Examples

##### Example 1

- **Output:**
```text
4
```
- **Explanation:** The longest common substring is "CDGH" with a length of 4.

##### Example 2

- **Input:**
```text
s1 = "abc", s2 = "acb"
```
- **Output:**
```text
1
```
- **Explanation:** The longest common substrings are "a", "b", "c" all having length 1.

##### Example 3

- **Input:**
```text
s1 = "YZ", s2 = "yz"
```
- **Output:**
```text
0Explanation: Comparison is case-sensitive, so 'Y' ≠ 'y' and 'Z' ≠ 'z'. Hence, no common substring exists.
```

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n * m)
- **Expected Auxiliary Space Complexity:** O(n * m)

### Accepted Solutions (2)

#### Solution 1 (C++)

- **Submitted:** 2026-11-26 21:37:14
- **Status:** Correct
- **Marks:** 0

```cpp
class Solution {
  public:
    int longCommSubstr(string& s1, string& s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        
        int dp[n+1][m+1];
        
        //initialization
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0) dp[i][j]=0;
            }
        }
        
        int maxi=0;
        
        //tabulation
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxi = max(maxi,dp[i][j]);
                }
                else{
                    dp[i][j] = 0; //breaking streak, due to 'substring'
                }
            }
        }
        
        return maxi;
    }
};
```

#### Solution 2 (C++)

- **Submitted:** 2024-08-14 19:42:11
- **Status:** Correct
- **Marks:** 4

```cpp
class Solution {
  public:
    int longestCommonSubstr(string s1, string s2) {
        // your code here
        int n = s1.length();
        int m = s2.length();
        
        vector<vector<int>> dp(n+1,vector<int>(m+1,0));
        
        int maxLen=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1[i-1]==s2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLen = max(maxLen,dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        
        return maxLen;
    }
};
```

*Generated on: 11/26/2026, 9:38:08 PM*