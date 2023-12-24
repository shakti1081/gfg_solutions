//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                String str=br.readLine();
                String[] starr=str.split(" ");
                
                //input n and d
                int n=Integer.parseInt(starr[0]);
                int k= Integer.parseInt(starr[1]);
                
                starr = br.readLine().trim().split(" ");
                int[] price = new int[n];
                for(int i = 0; i < n; i++)
                    price[i] = Integer.parseInt(starr[i]);
                
                Solution obj = new Solution();
                int res = obj.buyMaximumProducts(n, k, price);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    
    
    class Solution {
        public static int buyMaximumProducts(int n, int k, int[] price) {
            long arr[] = new long[n];
            
            for(int i=0; i<n; i++){
                arr[i]=price[i]*100000 +(i+1);
                // here i is starting from day 0 so we've to  write it as i+1
                // one more prob we will get as arr[i] will go in long so instead of int we've to write long
            }
            
            Arrays.sort(arr);//sorting
            
            int count =0;// we will count no' of stocks
            
            // we will extract int price separately for that we will make one more loop
            for(int i=0; i<n;i++){
                // we can extract both price and day by this loop
                int pr = (int)arr[i]/100000;
                // we will convert long into int first 
                // let's denote the price by pr bcoz there is already array named price 
                int day = (int)arr[i]%100000; 
                // by this loop we done this work by 1D array instead of 2D array
                
                if(k>=pr*day){
                    count = count + day;
                    k = k-pr*day;
                }
                else{
                    count +=(k/pr);
                    k =k-(k/pr)*pr;
                    
                } 
            }
            return count;
        }
    }
            
    