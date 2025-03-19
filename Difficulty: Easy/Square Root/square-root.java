//{ Driver Code Starts
import java.util.Scanner;

class SquartRoot {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int a = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.floorSqrt(a));
            t--;
        }
    }
}
// } Driver Code Ends


/*You are required to complete
this function*/

// Function to find square root
// x: element to find square root
class Solution {
    int floorSqrt(int n) {
        // Your code here
        int s=1;
        int e=n;
        int ans=-1;
        while(s<=e){
            int m = s + (e-s)/2;
            if(m*m>n){
                e=m-1;
            }
            else if(m*m<n){
                ans=m;
                s=m+1;
            }
            else{
                return m;
            }
        }
        
        return ans;
    }
}
