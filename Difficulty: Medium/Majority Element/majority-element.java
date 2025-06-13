class Solution {
    static int majorityElement(int arr[]) {
        // code here
        int n=arr.length;
        int cad=arr[0];
        int cnt=0;
        
        //voting algo..
        //this loop -> return "cad" which repeated the most in array
        for(int i: arr){
            
            if(cad==i){
                cnt++;
            }
            else{
                cnt--;
            }
            
            if(cnt==0){ //cad changed
                cad=i;
                cnt=1;
            }
        }
        
        //now we got the "cad" but need to check count > (n/2);
        int count=0;
        for(int i: arr){
            if(i==cad){
                count++;
            }
        }
        
        // System.out.println(count+" "+cad);
        
        if(count>(n/2)) return cad;
        
        return -1;
    }
}