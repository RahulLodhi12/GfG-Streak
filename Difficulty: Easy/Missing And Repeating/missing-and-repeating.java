//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList; // Import ArrayList
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            // Get the result as an ArrayList<Integer>
            ArrayList<Integer> ans = new Solution().findTwoElement(arr);
            System.out.println(ans.get(0) + " " + ans.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        int n=arr.length;
        
        //repeat and miss ->  x and y
        
        //s1-s1n (x-y)
        //s2-s2n (x2-y2) = (x-y)(x+y)
        
        long s1=0;
        for(int i: arr){
            s1+=i;
        }
        long s1n = (long)(n*(long)(n+1))/2;
        
        long s2=0;
        for(int i: arr){
            s2+=(long)i*i;
        }
        long s2n = (long)(n*(long)(n+1)*(long)(2*n+1))/6;
        
        //finding x+y:
        long v1 = s1-s1n; //x-y
        long v2 = s2-s2n; //x2-y2
        
        long v3 = v2/v1; //x+y
        
        //x
        long x = (v1+v3)/2;
        
        //y
        long y = v3-x;
        
        ans.add((int)x);
        ans.add((int)y);
        
        return ans;
    }
}
