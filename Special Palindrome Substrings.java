Question Link: https://practice.geeksforgeeks.org/problems/d7cd0429f9cf85f421831c4f6d50fad99566c1f9/1



class Solution{
    public  static int specialPalindrome(String a, String b){
       //Code Here
       char s1[] = a.toCharArray(), s2[] = b.toCharArray();
       int l1 = s1.length, l2 = s2.length, ans = Integer.MAX_VALUE;
       for(int i=0 ; i<l1-l2+1 ; i++){
           char temp[]=(a.substring(0,i)+b+a.substring(i+l2)).toCharArray();
           int cost=0;
    
            for(int j=i ; j<i+l2 ; j++){
                if(s1[j]!=temp[j])
                    cost++;
            }
            int z=0;
            for(int j=0 ; j<Math.ceil(l1/2.0) ; j++){
    
                if((j<i || j>=i+l2) && temp[j]!=temp[l1-j-1]) 
                    cost++;
                else if(temp[j]!=temp[l1-j-1] && (l1-j-1<i || l1-j-1>=i+l2)) 
                    cost++;
                else if(temp[j]!=temp[l1-j-1]){ 
                    z=1;
                    break;
                }
            }
            if(z==0)
                ans=Math.min(ans,cost);
       }
       if(ans == Integer.MAX_VALUE){
          return -1;
        }
        return ans;
    }
}
