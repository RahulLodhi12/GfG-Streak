//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] weights, int n, int days) {
        // code here
        int sum=0;
        int maxi=-1;
        for(int i: weights){
            sum+=i;
            maxi=Math.max(i,maxi);
        }

        int s=maxi;
        int e=sum;
        int ans=-1;
        while(s<=e){
            int mid = s + (e-s)/2; //cap
            int dcnt=1;
            int w=0;
            for(int i: weights){
                if(w + i>mid){
                    dcnt++; //move to next day
                    w = i; //move to new weight for next day
                }
                else{
                    w += i;
                }

            }
            
            if(dcnt<=days){ //ans is store
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }

        return ans;
    }
};