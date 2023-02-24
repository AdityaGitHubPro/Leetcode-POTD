Question Link: https://leetcode.com/problems/minimize-deviation-in-array/



class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 1) {
                num *= 2;
            }
            pq.offer(num);
            min = Math.min(min, num);
        }
        int ans = Integer.MAX_VALUE;
        while (true) {
            int max = pq.poll();
            ans = Math.min(ans, max - min);
            if (max % 2 == 0) {
                pq.offer(max / 2);
                min = Math.min(min, max / 2);
            } else {
                break;
            }
        }
        return ans;
    }
}
