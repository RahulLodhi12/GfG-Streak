//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.kokoEat(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kokoEat(int[] piles, int h) {
        // code here
        int maxi = Integer.MIN_VALUE;

        for(int i: piles){
            maxi = Math.max(i,maxi);
        }

        int s=1,e=maxi;
        int ans=-1;
        while(s<=e){
            int m = s + (e-s)/2; //k
            int total=0; //total hours
            for(int i: piles){
                total += Math.ceil((double)i/m);
            }

            if(total<=h){
                ans = m;
                e=m-1;
            }
            else{
                s=m+1;
            }
        }

        return ans;
    }
}
