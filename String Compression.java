Quetion Link: https://leetcode.com/problems/string-compression/



class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        int index = 0;
        int count = 1;
        char prev = chars[0];
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                chars[index++] = prev;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[index++] = countStr.charAt(j);
                    }
                }
                prev = chars[i];
                count = 1;
            }
        }
        
        chars[index++] = prev;
        if (count > 1) {
            String countStr = String.valueOf(count);
            for (int j = 0; j < countStr.length(); j++) {
                chars[index++] = countStr.charAt(j);
            }
        }
        
        return index;
    }
}
