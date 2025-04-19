//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driver {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String arr1[] = br.readLine().split(" ");
            int[] a = new int[arr1.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(arr1[i]);

            String arr2[] = br.readLine().split(" ");
            int[] b = new int[arr2.length];

            for (int i = 0; i < arr2.length; i++) b[i] = Integer.parseInt(arr2[i]);

            if (b.length == 1 && b[0] == 0) {
                b = new int[0];
            }
            double res = new Solution().medianOf2(a, b);

            if (res == (int)res)
                System.out.println((int)res);
            else
                System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public double medianOf2(int nums1[], int nums2[]) {
        // Your Code Here
        int n=nums1.length;
        int m=nums2.length;

        int[] temp = new int[n+m];

        int i=0,j=0;
        int k=0;

        while(i<n && j<m){
            if(nums1[i]<=nums2[j]){
                temp[k++]=nums1[i];
                i++;
            }
            else{
                temp[k++]=nums2[j];
                j++;
            }
        }

        while(i<n){
            temp[k++]=nums1[i++];
        }

        while(j<m){
            temp[k++]=nums2[j++];
        }

        int len = temp.length;

        if(len%2==0){
            double median = (double)(temp[len/2] + temp[(len/2)-1])/2;
            return median;
        }

        return (double)temp[len/2];
    }
}