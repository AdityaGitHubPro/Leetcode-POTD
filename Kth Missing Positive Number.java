Question Link: https://leetcode.com/problems/kth-missing-positive-number/



class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int missingCount = arr[0] - 1;
        if (missingCount >= k) {
            return k;
        }
        missingCount = arr[n - 1] - n;
        if (missingCount < k) {
            return n + k;
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            missingCount = arr[mid] - mid - 1;
            if (missingCount >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return k + high + 1;
    }
}
