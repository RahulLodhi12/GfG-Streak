//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends

// User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        HashMap<Integer,Integer> mpp = new HashMap<>();
        
        for(int i: arr){
            mpp.put(i,mpp.getOrDefault(i,0)+1);
        }
        
        ArrayList<Pair> vec = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> i: mpp.entrySet()){
            vec.add(new Pair(i.getKey(),i.getValue()));
        }
        
        Collections.sort(vec,(a,b)->{
           if(a.second==b.second){
               return a.first - b.first; //inc. -> small - big OR Integer.compare(small, big)
           } 
           return b.second - a.second; //dec. -> big - small OR Integer.compare(big, small)
        });
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<vec.size();i++){
            while(vec.get(i).second>0){
                ans.add(vec.get(i).first);
                vec.get(i).second--;
            }
        }
        
        return ans;
    }
}


//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends