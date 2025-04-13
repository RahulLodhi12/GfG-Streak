//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int nums[], int k) {
        // code here
        int prefixXor=0;

        HashMap<Integer,Integer> mpp = new HashMap<>(); //map<prefixXor,cnt>
        long cnt=0;

        mpp.put(0,1);

        for(int i: nums){
            prefixXor^=i;

            if(mpp.containsKey(prefixXor^k)){ //opposite of XOR is 'XOR' in programming.
                cnt+=mpp.get(prefixXor^k);
            }

            if(mpp.containsKey(prefixXor)){
                mpp.put(prefixXor,mpp.getOrDefault(prefixXor,0)+1);
            }
            else{
                mpp.put(prefixXor,1);
            }
        }

        return cnt;
    }
}