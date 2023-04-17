Question Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/



class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max=0;
        for(int candy : candies){
            if(candy>max)
            {
                max=candy;
            }
        }
        
        max= max-extraCandies;
        for(int z: candies )
        {
            result.add(z>=max);       
        }
        return result; 
    }
}
