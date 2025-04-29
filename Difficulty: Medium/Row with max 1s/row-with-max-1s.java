//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        sc.nextLine();        // Consume the newline character

        while (t-- > 0) {
            String input = sc.nextLine();

            // Replace ][ with ],[
            input = input.replace("][", "],[");

            ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
            String[] rows = input.split("],\\s*\\[");

            for (String row : rows) {
                row = row.replaceAll("[\\[\\]]", ""); // Remove any surrounding brackets
                ArrayList<Integer> intRow = new ArrayList<>();
                for (String num : row.split(",")) {
                    intRow.add(Integer.parseInt(num.trim()));
                }
                mat.add(intRow);
            }

            Solution obj = new Solution();
            int result = obj.rowWithMax1s(convertListToArray(mat));

            System.out.println(result);

            System.out.println("~");
        }
        sc.close();
    }

    // Helper method to convert ArrayList<ArrayList<Integer>> to 2D array
    public static int[][] convertListToArray(ArrayList<ArrayList<Integer>> mat) {
        int rows = mat.size();
        int cols = mat.get(0).size();
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = mat.get(i).get(j);
            }
        }
        return arr;
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int lowerBound(int nums[], int x, int n){
        int s=0,e=n-1;
        int idx = n;
        while(s<=e){
            int mid = s + (e-s)/2;
            
            if(nums[mid]>=x){
                idx = Math.min(idx,mid);
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        
        return idx;
    }
    public int rowWithMax1s(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        
        int maxi = Integer.MIN_VALUE;
        int cnt = 0;
        int idx=-1;
        
        for(int i=0;i<n;i++){
            cnt += (m-lowerBound(mat[i],1,m));
            if(cnt>maxi){
                maxi = cnt;
                idx=i;
            }
            cnt=0;
        }
        return idx;
    }
}