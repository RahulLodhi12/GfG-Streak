## 01. Longest Substring with K Uniques

The problem can be found at the following link: [Question Link](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)

### Problem Description

**Task:** You are given a string s consisting only lowercase alphabets and an integer k. Your task is to find the length of the longest substring that contains exactly k distinct characters.Note : If no such substring exists, return -1. Examples:Input: s = "aabacbebebe", k = 3

#### Examples

##### Example 1

- **Output:**
```text
7
```
- **Explanation:** The longest substring with exactly 3 distinct characters is "cbebebe", which includes 'c', 'b', and 'e'.

##### Example 2

- **Input:**
```text
s = "aaaa", k = 2
```
- **Output:**
```text
7
```
- **Explanation:** The entire string "aabaaab" has exactly 2 unique characters 'a' and 'b', making it the longest valid substring.

### Time and Auxiliary Space Complexity

- **Expected Time Complexity:** O(n)
- **Expected Auxiliary Space Complexity:** O(1)

### Accepted Solutions (1)

#### Solution 1 (C++)

- **Submitted:** 2023-12-16 13:21:43
- **Status:** Correct
- **Marks:** 4

```cpp
//User function template for C++

class Solution{
  public:
    int longestKSubstr(string s, int k) {
    // your code here
        int i=0,j=0;
        int n = s.size();

        unordered_map<char,int> mpp;

        int maxLen=-1;

        while(j<n){
            mpp[s[j]]++;

            if(mpp.size()<k){
                j++;
            }

            else if(mpp.size()==k){
                maxLen = max(maxLen,j-i+1);
                j++;
            }

            else if(mpp.size() > k){
                while(mpp.size() > k){
                    mpp[s[i]]--;
                    if(mpp[s[i]]==0){
                        mpp.erase(s[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        return maxLen;
    }
};
```

*Generated on: 11/8/2026, 1:10:58 AM*