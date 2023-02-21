Question Link: https://leetcode.com/problems/single-element-in-a-sorted-array/



class Solution {
    public int singleNonDuplicate(int[] nums) {
       int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
                if (mid % 2 == 1) mid--; // ensure mid is even index
                if (nums[mid] != nums[mid + 1]) hi = mid; // single element is in the     left half
                else lo = mid + 2; // single element is in the right half
        }       
        return nums[lo]; 
    }
}
