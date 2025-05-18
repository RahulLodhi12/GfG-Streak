//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(ArrayList<String> a) {
        for (String e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }

            Solution obj = new Solution();
            ArrayList<String> v = obj.possibleWords(a);
            Collections.sort(v); // Sorting the ArrayList lexicographically
            IntArray.print(v);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public void solve(int idx, int[] digits, int n, HashMap<Integer,String> mpp, ArrayList<Character> temp, ArrayList<String> ans){
        //base case
        if(temp.size()==n){
            StringBuilder sb = new StringBuilder();
            for(Character ch: temp){
                sb.append(ch);
            }
            String curr = sb.toString();
            ans.add(curr);
            return;
        }

        int ch = digits[idx];
        String s = mpp.get(ch);
        int k = s.length();

        for(int i=0;i<k;i++){
            temp.add(s.charAt(i));
            solve(idx+1,digits,n,mpp,temp,ans);
            temp.remove(temp.size()-1);
        }

    }
    public ArrayList<String> possibleWords(int[] digits) {
        // code here
        int n = digits.length;
        if(n==0) return new ArrayList<>();
        
        ArrayList<Character> temp = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();


        //Map
        HashMap<Integer,String> mpp = new HashMap<>();
        mpp.put(2,"abc");
        mpp.put(3,"def");
        mpp.put(4,"ghi");
        mpp.put(5,"jkl");
        mpp.put(6,"mno");
        mpp.put(7,"pqrs");
        mpp.put(8,"tuv");
        mpp.put(9,"wxyz");

        solve(0,digits,n,mpp,temp,ans);

        return ans;
    }
}