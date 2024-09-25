//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution
{
    public:
    //Function to check if two strings are rotations of each other or not.
    bool areRotations(string s,string g)
    {
        // Your code here
        string t=g+g;
        int n=s.size();
        int cnt=0;
        int j=0;
        for(int i=0;i<t.size();i++){
            if(j==s.size()) break;
            if(t[i]==s[j]){
                cnt++;
                j++;
            }
        }
        return cnt==s.size();
    }
};

//{ Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string s1;
        string s2;
        cin>>s1>>s2;
        Solution obj;
        cout<<obj.areRotations(s1,s2)<<endl;

    }
    return 0;
}

// } Driver Code Ends