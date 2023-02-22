Question Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/



class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight); // maximum weight of a single package
            right += weight; // total weight of all packages
        }
        while (left < right) {
            int mid = (left + right) / 2;
            int daysNeeded = 1, currentWeight = 0;
            for (int weight : weights) {
                if (currentWeight + weight > mid) {
                    daysNeeded++;
                    currentWeight = 0;
                }
                currentWeight += weight;
            }
            if (daysNeeded <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left; 
    }
}
