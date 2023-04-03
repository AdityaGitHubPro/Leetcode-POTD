Question Link: https://leetcode.com/problems/successful-pairs-of-spells-and-potions/


class Solution {
    
    Map<Integer, int[]> duplicates;

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] pairs = new int[spells.length];
        Arrays.sort(potions);
        int ind = 0;
        duplicates = new HashMap<>();
        for (int i = 0; i < potions.length; i++) {
            if (duplicates.containsKey(potions[i])) {
                int[] idx = duplicates.get(potions[i]);
                duplicates.put(potions[i], new int[]{idx[0], i});
            } else duplicates.put(potions[i], new int[]{i});
        }

        for (int s : spells) {
            int idx = bs(potions, (long) Math.ceil((double) success / s));
            if (idx >= 0) {
                pairs[ind++] = potions.length - idx;
            } else {
                pairs[ind++] = 0;
            }
        }
        return pairs;
    }

    private int bs(int[] potions, long value) {
        int l = 0, h = potions.length - 1;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (value < potions[mid]) {
                h = mid;
            } else if (value > potions[mid]) {
                l = mid + 1;
            } else if (value == potions[mid]) {
                return duplicates.get(potions[mid])[0];
            }
        }

        return potions[l] < value ? -1 : l;
    }
}
