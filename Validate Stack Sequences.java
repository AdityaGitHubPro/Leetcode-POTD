Question Link: https://leetcode.com/problems/validate-stack-sequences/description/



class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0; //pointer to push array
        int j = 0; //pointer to popped array
        
        for(int val : pushed){
            pushed[i++] = val; // using pushed as the stack.
            while(i > 0 && pushed[i - 1] == popped[j]){ // pushed[i - 1] values equal to popped[j];
                i--; 
                j++;
            }
        }
        return i == 0; // Since pushed is a permutation of popped so at the end we are supposed to be left with an empty stack
    }
}
