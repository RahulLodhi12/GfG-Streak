//{ Driver Code Starts
// Initial template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int pairsum(vector<int> &arr) {
        // code here
        int l1=INT_MIN;
        int l2=INT_MIN;
        for(int i: arr){
            if(i>l1){
                l1=i;
            }
        }
        for(int i: arr){
            if(i>l2 and i<l1){
                l2=i;
            }
        }
        
        // cout<<l1<<" "<<l2;
        return l1+l2;
    }
};


//{ Driver Code Starts.
int main() {
    int t;

    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int n = arr.size();
        Solution ob;
        int r = ob.pairsum(arr);
        cout << r << endl;
    }
    return 0;
}
// } Driver Code Ends