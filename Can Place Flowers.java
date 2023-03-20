Question Link: https://leetcode.com/problems/can-place-flowers/



class Solution {
		public boolean canPlaceFlowers(int[] flowerbed, int n) {
		for (var i = 0; i < flowerbed.length && n > 0; i++) 
		if (flowerbed[i] == 0) {
			var leftEmpty = (i == 0) || (flowerbed[i - 1] == 0);
			var rightEmpty = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
			
			if (leftEmpty && rightEmpty) {
				flowerbed[i] = 1; // plant the flower
				n--;
			}
		}
		return n == 0;
	}
}
