//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to count inversions in the array.
    static int merge(int[] nums, int l, int m, int h){
        ArrayList<Integer> temp = new ArrayList<>();
        int i=l;
        int j=m+1;
        int cnt=0;

        while(i<=m && j<=h){
            if(nums[i]<=nums[j]){
                temp.add(nums[i]);
                i++;
            }
            else{
                temp.add(nums[j]);
                j++;
                cnt+=(m-i+1);
            }
        }

        while(i<=m){
            temp.add(nums[i]);
            i++;
        }

        while(j<=h){
            temp.add(nums[j]);
            j++;
        }

        int p=0;
        for(int k=l;k<=h;k++){
            nums[k]=temp.get(p);
            p++;
        }

        return cnt;
    }
    static int mergeSort(int[] nums, int l, int h){
        int count=0;
        if(l>=h) return count; //base case

        int m = (l+h)/2;

        count+=mergeSort(nums,l,m); //divide
        count+=mergeSort(nums,m+1,h); //divide

        count+=merge(nums,l,m,h); //merge

        return count;
    }
    static int inversionCount(int nums[]) {
        // Your Code Here
        int n=nums.length;
        return mergeSort(nums,0,n-1);
    }
}