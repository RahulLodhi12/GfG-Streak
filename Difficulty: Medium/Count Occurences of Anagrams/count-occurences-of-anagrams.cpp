//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	int search(string pat, string txt) {
	    // code here
	    vector<int> hp(26,0);
	    for(char ch: pat){
	        hp[ch-'a']++;
	    }
	    
	    vector<int> ht(26,0);
	    int n=txt.size();
	    int i=0;
	    int j=0;
	    int k=pat.size();
	    int cnt=0;
	    while(j<n){
	        ht[txt[j]-'a']++;
	        if(j-i+1<k){
	            j++;
	        }
	        else if(j-i+1==k){
	            if(hp==ht) cnt++;
	            ht[txt[i]-'a']--;
	            i++;
	            j++;
	        }
	    }
	    return cnt;
	    
	}

};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string pat, txt;
        cin >> txt >> pat;
        Solution ob;
        auto ans = ob.search(pat, txt);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends