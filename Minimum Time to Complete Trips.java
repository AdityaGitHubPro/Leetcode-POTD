Question Link: https://leetcode.com/problems/minimum-time-to-complete-trips/



class Solution {
    public long minimumTime(int[] time, int totalTrips) {
       int n = time.length;
        long left = 1, right = (long)1e18;
        while (left < right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int t : time) {
                cnt += mid / t;
                if (cnt >= totalTrips) break;
            }
            if (cnt >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left; 
    }
}
