//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static class Pair{
        double first;
        int second;
        Pair(double first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n=stations.length;
        
        int[] fillGap = new int[n-1];
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.first, a.first));
        
        for(int i=0;i<n-1;i++){
            pq.add(new Pair(stations[i+1]-stations[i],i));
        }
        
        for(int gas=1;gas<=k;gas++){
            Pair top = pq.poll();
            int idx = top.second;
            
            //insert current gas station
            fillGap[idx]++;
            
            double diff = stations[idx+1] - stations[idx];
            double secLen = diff/(fillGap[idx]+1);
            
            //add to pq
            pq.add(new Pair(secLen,idx));
        }
        
        return pq.peek().first;
    }
}
