//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int n = input_line.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input_line[i]);
            int k = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr, k));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minTime(int[] arr, int k) {
        // code here
        int maxi=-1;
        int sum=0;
        for(int i: arr){
            maxi = Math.max(maxi,i);
            sum+=i;
        }
        
        int s=maxi;
        int e=sum;
        int ans=-1;
        
        while(s<=e){
            int mid=s+(e-s)/2; //minTime
            int p=1;
            int time=0;
            for(int i: arr){
                if(time+i<=mid){
                    time+=i;
                }
                else{
                    p++;
                    time=i;
                }
            }
            if(p<=k){ //ans store here
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        
        return ans;
        
        // Brute Force code:
        // for(int minTime=maxi;minTime<=sum;minTime++){
        //     int p=1;
        //     int time=0;
        //     for(int i: arr){
        //         if(time+i<=minTime){
        //             time+=i;
        //         }
        //         else{
        //             p++;
        //             time=i;
        //         }
        //     }
        //     if(p<=k) return minTime;
        // }
        
        // return -1;
    }
}
