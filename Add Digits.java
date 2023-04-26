class Solution {
    public int addDigits(int num) {
       int temp = 0 ;
        temp = numn(num);
        while(temp > 9){
           temp = numn(temp);
        }
        return temp;
        
    }
    
    public int numn(int num){
      int temp = 0;
      while(num > 9){
            temp += num % 10 ;
            num /= 10;
        }
        return temp + num; 
    }
}
