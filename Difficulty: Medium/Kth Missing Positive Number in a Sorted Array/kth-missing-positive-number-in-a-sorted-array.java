//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.kthMissing(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n=arr.length;
        int s=0,e=n-1; //low=0, high=n-1

        while(s<=e){
            int mid = s + (e-s)/2;
            
            int missing = arr[mid] - (mid+1); //missing numbers

            if(missing<k){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }

        return k + e + 1; //equals to arr[high] + 'more', here 'more' is 'k-missing'
    }
}