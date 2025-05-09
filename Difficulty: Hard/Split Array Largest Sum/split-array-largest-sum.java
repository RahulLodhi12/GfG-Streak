//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] nums, int N, int k) {
        // code here
        int maxi=-1;
        int sum=0;
        for(int i: nums){
            maxi=Math.max(maxi,i);
            sum+=i;
        }

        int s=maxi;
        int e=sum;
        int ans=-1;
        
        while(s<=e){
            int mid = s + (e-s)/2; //minSum
            int cnt=1;
            int total=0;
            for(int i: nums){
                if(total+i<=mid){
                    total+=i;
                }
                else{
                    cnt++;
                    total=i;
                }
            }
            if(cnt<=k){ //ans store here
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }

        return ans;


        // Brute Force Code:
        // for(int minSum=maxi;minSum<=sum;minSum++){
        //     int cnt=1;
        //     int total=0;
        //     for(int i: nums){
        //         if(total+i<=minSum){
        //             total+=i;
        //         }
        //         else{
        //             cnt++;
        //             total=i;
        //         }
        //     }
        //     if(cnt<=k) return minSum;
        // }

        // return -1;
    }
};