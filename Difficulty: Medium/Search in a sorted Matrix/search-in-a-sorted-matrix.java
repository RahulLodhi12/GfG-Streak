//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t > 0) {
            int rows = sc.nextInt();
            int columns = sc.nextInt();

            int matrix[][] = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int target = sc.nextInt();

            Solution x = new Solution();

            if (x.searchMatrix(matrix, target))
                System.out.println("true");
            else
                System.out.println("false");
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean binarySearch(int[] nums, int x){
        int size = nums.length;
        int s=0,e=size-1;
        
        while(s<=e){
            int m = s + (e-s)/2;
            if(nums[m]>x){
                e=m-1;
            }
            else if(nums[m]<x){
                s=m+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        for(int i=0;i<n;i++){
            if(mat[i][0]<=x && x<=mat[i][m-1]){
                return binarySearch(mat[i],x);
            }
        }
        
        return false;
    }
}
