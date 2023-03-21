Question Link: https://leetcode.com/problems/number-of-zero-filled-subarrays/



class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = 0;
            while (i < nums.length && nums[i] == 0) {
                cur += 1;
                res += cur;
                i++;
            }
        }
        return res;
    }
}
