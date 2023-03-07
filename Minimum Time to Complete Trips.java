Question Link: https://leetcode.com/problems/minimum-time-to-complete-trips/



// class Solution {
//     public long minimumTime(int[] time, int totalTrips) {
//        int n = time.length;
//         long left = 1, right = (long)1e18;
//         while (left < right) {
//             long mid = (left + right) / 2;
//             long cnt = 0;
//             for (int t : time) {
//                 cnt += mid / t;
//                 if (cnt >= totalTrips) break;
//             }
//             if (cnt >= totalTrips) {
//                 right = mid;
//             } else {
//                 left = mid + 1;
//             }
//         }
//         return (int)left; 
//     }
// }


class Solution {
    int[] times;
    int totalTrips;
    
    public long minimumTime(int[] times, int totalTrips) {
        this.times = times;
        this.totalTrips = totalTrips;
        long left = 1;
        long right = 0;
        for (int time : times) {
            right = Math.max(right, time);
        }
        right = right * totalTrips;
        long ans = right;
        while (left <= right) {
            long mid = (left + right) / 2;
            if (check(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    
    public boolean check(long givenTime) {
        long actualTrips = 0;
        for (int time : times) {
            actualTrips += givenTime / time;
            if (actualTrips >= totalTrips) {
                return true;
            }
        }
        return actualTrips >= totalTrips;
    }
}
