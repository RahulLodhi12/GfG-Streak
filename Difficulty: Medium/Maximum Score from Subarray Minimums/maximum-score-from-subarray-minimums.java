//{ Driver Code Starts
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }
            int[] arr = new int[nums.size()];
            int idx = 0;
            for (int i : nums) arr[idx++] = i;
            Solution solution = new Solution();
            System.out.println(solution.pairWithMaxSum(arr));

            System.out.println("~");
        }

        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(int arr[]) {
        // Your code goes here
        //Sliding window concept with window size k=2
        //since maximum Sum for this question will always be the sum of adjacent elements in pair(k=2)
        int k=2;
        int n=arr.length;
        int i=0,j=0;
        int sum=0;
        int maxSum=0;
        while(j<n){
            sum+=arr[j];
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                maxSum=Math.max(maxSum,sum);
                sum-=arr[i];
                i++;
                j++;
            }
        }
        return maxSum;
    }
}
