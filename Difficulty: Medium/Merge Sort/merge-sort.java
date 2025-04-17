//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            new Solution().mergeSort(arr, 0, arr.length - 1);

            for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");

            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    void merge(int[] nums, int l, int m, int h){
        int[] temp = new int[h - l + 1];
        int i=l;
        int j=m+1;
        int p=0;

        while(i<=m && j<=h){
            if(nums[i]<=nums[j]){
                temp[p++]=nums[i];
                i++;
            }
            else{
                temp[p++]=nums[j];
                j++;
            }
        }

        while(i<=m){
            temp[p++]=nums[i];
            i++;
        }

        while(j<=h){
            temp[p++]=nums[j];
            j++;
        }

        int q=0;
        for(int k=l;k<=h;k++){
            nums[k]=temp[q++];
        }
    }
    void mergeSort(int nums[], int l, int h) {
        // code here
        if(l>=h) return; //base case

        int m = (l+h)/2;

        mergeSort(nums,l,m); //divide
        mergeSort(nums,m+1,h); //divide

        merge(nums,l,m,h); //merge
    }
}
